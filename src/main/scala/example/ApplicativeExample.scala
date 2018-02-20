package example


object FunctorExample {
  import cats.Functor
  import cats.instances.list._
  import cats.instances.option._

  val listOption = List(Some(1), None, Some(2))
  Functor[List].compose[Option].map(listOption)(_ + 1)

}


object ApplicativeExample {
  import cats.Applicative._
  import cats.Applicative._




}