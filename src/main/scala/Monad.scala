trait Monad[F[_]] {

  def pure[A](value: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A, B](value: F[A])(func: A => B): F[B] =
    flatMap(value)(a => pure(func(a)))
}

trait MonadLaws[F[_]] extends Monad[F] {

  def leftIdentity[A, B](a: A)(f: A => F[B]): Boolean =
    flatMap(pure(a))(f) == f(a)

  def rightIdentityIdentity[A, B](m: F[A]): Boolean =
    flatMap(m)(pure) == m

  def associativity[A, B, C](m: F[A])(f: A => F[B], g: B => F[C]): Boolean =
    flatMap(flatMap(m)(f))(g) == flatMap(m)(x => flatMap(f(x))(g))

}