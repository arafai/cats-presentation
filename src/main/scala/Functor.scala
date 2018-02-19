trait Functor[F[_]] {

  def map[A, B](fa: F[A])(f: A => B): F[B]
}

trait FunctorLaws[F[_]] extends Functor[F] {

  def identityLaw[A](fa: F[A]): Boolean =
    map(fa)(a => a) == fa

  def composition[A, B, C](fa: F[A])(f: A => B, g: B => C): Boolean =
    map(fa)(f andThen g) == map(map(fa)(f))(g)
}