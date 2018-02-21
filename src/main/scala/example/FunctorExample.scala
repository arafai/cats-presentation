package example

import cats.Functor
import cats.instances.list._
import cats.instances.option._

object FunctorExample {

  // functor example
  val f = (x: Int) => x.toString

  val result: List[String] = List.apply(1, 2, 3).map(f)


  // functor compose
  val listOption = List(Some(1), None, Some(2))
  Functor[List].compose[Option].map(listOption)(_ + 1)

  //alternative
  List(Some(1), None, Some(2)).map(_.map(_ + 1))


  val g: Int => Int => Int = ((x: Int, y: Int) => x + y).curried

  val resultG: List[Int => Int] = List.apply(1, 2, 3).map(g)

  // cannot easily be mapped anymore, as now map has the type map[B](f:(Int,Int) => B):F[B]
  //resultG.map(...)


  val myVeryOwnFunctor =
    new Functor[List] {
      override def map[A, B](fa: List[A])(f: A => B): List[B] =
        fa.reverse.map(f)
    }

}
