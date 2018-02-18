trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

trait FunctorLaws[F[_]] extends Functor[F]{

  //  fa.map(a => a) == fa
  def identityLaw[F[_], A](fa: F[A]): Boolean = {
    map(fa)(a => a) == fa
  }

  //  fa.map(g(f(_))) == fa.map(f).map(g)
  def composition[F[_], A, B, C](fa: F[A])(f: A => B, g: B => C): Boolean =
    map(fa)(f andThen g) == map(map(fa)(f))(g)
}