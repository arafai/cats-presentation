package example

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import models.{AdminLevel, CoordToAdminLevelsMap, Coordinates}

import scala.concurrent.duration.Duration

package object models {

  case class AdminLevel(level1: String = "", level2: String = "")

  case class Coordinates(lat: Double, long: Double)

  type AdminLevels = Vector[AdminLevel]
  type CoordToAdminLevelsMap = Map[Coordinates, AdminLevel]
}

package object NonCats {

  private def fetchInBatches(coordinates: Vector[Coordinates]): Vector[Future[Option[CoordToAdminLevelsMap]]] = ???

  def fetchGeoLocation(batches: Vector[Future[Option[CoordToAdminLevelsMap]]]): Future[CoordToAdminLevelsMap] = {

    val batchResultFuture: Future[Vector[Option[CoordToAdminLevelsMap]]] =
      Future.sequence(batches)

    val almostResult: Future[Vector[(Coordinates, AdminLevel)]] =
      batchResultFuture.map { data: Vector[Option[CoordToAdminLevelsMap]] =>
        data
          .foldLeft(Vector.empty[(Coordinates, AdminLevel)]) { case (accumulator, element) =>
            element match {
              case Some(coordinatesToAdminLevels: CoordToAdminLevelsMap) =>
                accumulator ++ coordinatesToAdminLevels.toVector
              case None => accumulator
            }
          }
      }

    almostResult.map { tupleVector =>
      val groupedByKey: Map[Coordinates, Vector[(Coordinates, AdminLevel)]] =
        tupleVector
          .groupBy { case (coordinateKey, _) => coordinateKey }

      val map: Map[Coordinates, AdminLevel] =
        groupedByKey
          .mapValues { cordinateToAdminLevels =>
            cordinateToAdminLevels
              .map { case (_, adminLevel) => adminLevel }
              .foldLeft(AdminLevel())((acc, adminLevel) =>
                AdminLevel(
                  level1 = acc.level1 + adminLevel.level1,
                  level2 = acc.level2 + adminLevel.level2
                )
              )
          }
      map
    }
  }
}


object Cats extends App {

  import cats.Monoid
  import cats.instances.map._
  import cats.instances.option._
  import cats.instances.string._
  import cats.instances.vector._
  import cats.instances.future._
  import cats.syntax.semigroup._
  import cats.syntax.foldable._

  implicit val adminLevelMonoid: Monoid[AdminLevel] =
    new Monoid[AdminLevel] {
      override def combine(x: AdminLevel, y: AdminLevel) =
        AdminLevel(
          level1 = x.level1 |+| y.level1,
          level2 = x.level2 |+| y.level2
        )

      override def empty = AdminLevel()
    }

  def fetchGeoLocation(batches: Vector[Future[Option[CoordToAdminLevelsMap]]]): Future[CoordToAdminLevelsMap] = {
    batches.combineAll.map(_.getOrElse(Map.empty))
  }


  val map = Vector(
    Future.successful(Some(
      Map(Coordinates(1d, 2d) -> AdminLevel("a", "b"))
    )),
    Future.successful(Some(
      Map(Coordinates(1d, 2d) -> AdminLevel("d", "d"))
    )),
    Future.successful(Some(
      Map(Coordinates(3d, 4d) -> AdminLevel("e", "g"))
    ))
  )

  val res = Await.result(fetchGeoLocation(map), Duration.Inf)

  res.foreach(println)

}
