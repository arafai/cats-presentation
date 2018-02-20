trait Semigroup[A] {

  def combine(x: A, y: A): A
}

trait SemigroupLaws[A] extends Semigroup[A] {

  def associativeLaw(x: A, y: A, z: A): Boolean =
    combine(x, combine(y, z)) == combine(combine(x, y), z)
}
