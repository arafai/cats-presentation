trait Monoid[A] {

  def combine(x: A, y: A): A

  def empty: A
}

trait MonoidLaws[A] extends Monoid[A] {

  def associativeLaw(x: A, y: A, z: A): Boolean =
    combine(x, combine(y, z)) == combine(combine(x, y), z)

  def identityLaw(x: A): Boolean =
    (combine(x, empty) == x) && (combine(empty, x) == x)
}