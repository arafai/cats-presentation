package example

import cats.Applicative
import cats.instances.future._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object ApplicativeExample extends App {

  case class Person(firstName: String, lastName: String, age: Int)

  val firstName = Future.successful("Andrei")
  val lastName = Future.successful("Rafai")
  val age = Future.successful(21)

  val personCreator: (String, String, Int) => Person = Person.apply

  Applicative[Future].map3(firstName, lastName, age)(personCreator)

  import cats._
  import cats.implicits._

  def sequenceList[F[_] : Applicative, A](list: List[F[A]]): F[List[A]] = list match {
    case Nil => Applicative[F].pure(Nil: List[A])
    case x :: xs => (x, sequenceList(xs)).mapN(_ :: _)
  }

  val result: Option[List[Int]] = sequenceList(List(1.some, 2.some))

  println(result)


  val myVeryOwnApplicative =
    new Applicative[List] {
      override def pure[A](x: A) = ???

      override def ap[A, B](ff: List[A => B])(fa: List[A]) = ???
    }
}