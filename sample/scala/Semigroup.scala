trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait SemigroupLaws[A] {
  def associativeLaw[A](x: A, y: A, z: A)
                       (implicit m: Monoid[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)
}
