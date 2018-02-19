trait Applicative[F[_]] extends Functor[F[_]]{

  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]

  def pure[A](a: A): F[A]

  def map[A, B](fa: F[A])(f: A => B): F[B] = ap(pure(f))(fa)

  def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] = {
    val value: F[B => (A, B)] = map(fa)(a => (b: B) => (a, b))
    ap(value)(fb)
  }
}

trait ApplicativeLaws[F[_]] extends Applicative[F] {

  def associativity[A, B, C](fa: F[A], fb: F[B], fc: F[C]): Boolean =
    product(product(fa, fb), fc) == product(fa, product(fb, fc))

  def leftIdentity[A](fa: F[A]): Boolean =
    map(product(pure(()), fa))(_._2) == fa

  def rightIdentity[A](fa: F[A]): Boolean =
    map(product(fa, pure(())))(_._1) == fa
}