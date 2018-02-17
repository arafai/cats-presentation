## A gentle introduction to category theory using Cats


---


@title[Category theory #1]

### Abstraction
### Composition
### Identity

Note:
Abstraction - getting rid of some unnecessary details => objects become identical
Composition - arguably, the most important feature
Identity

Composition and identity are the foundation of the category theory


---


@title[Category theory #2]

### Objects
### Morphisms

Note:
Category is a bunch of objects + morphisms
An object - has no property, no structure
Morphism - no property except that is has a beginning and an end
A category could be considered as a graph, 1 or multiple arrows between 2 nodes, both ways
All morphism could be considered as a multiplication table (all the information),
you have an a morphism  and  then you have an arrow


---


@title[Category theory #3]

#### TODO add visual representation for objects, morphisms

Note: Identity - every object has a identity


---


@title[Category theory laws #1]

#### Composition
### TODO add image for composition


---


@title[Category theory laws #2]

#### Identity
### TODO add image for Identity (with composition)

Note: 
Every object must have an identity  


---


@title[Category theory laws #3]

#### Associativity
### TODO add image for Associativity


---


@title[Monoid #1]

#### Monoid
### TODO add image for Monoid


---


@title[Monoid #2]

```scala

trait Monoid[A] {
  def combine(x: A, y: A): A

  def empty: A
}

trait MonoidLaws {
  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean =
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
}

```

---?code=sample/scala/Semigroup.scala&lang=scala&title=Semigroup

---
