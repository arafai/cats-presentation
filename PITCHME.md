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


@title[Monoid]

#### Monoid
### TODO add image for Monoid

---

#### Monoid typeclass

+++?code=src/main/scala/Monoid.scala&lang=scala&title=Monoid

@[1-5]
@[8]
@[10-12]
@[14-15]


---

#### Semigroup typeclass

+++?code=src/main/scala/Semigroup.scala&lang=scala&title=Semigroup

@[1-4]
@[6]
@[8-10]


---


@title[Functor]

### TODO add image functor 

Note:
A functor is a mapping between categories. 
Given two categories, C and D, a functor F maps objects in C to objects in D — it’s a function on objects.
If a is an object in C, we’ll write its image in D as F a (no parentheses).
But a category is not just objects — it’s objects and morphisms that connect them.
A functor also maps morphisms — it’s a function on morphisms. But it doesn’t map morphisms willy-nilly —
Anything with a map function.

---

#### Functor typeclass

+++?code=src/main/scala/Functor.scala&lang=scala&title=Functor

@[1-4]
@[6]
@[8-11]
@[13-15]


---

#### Applicative typeclass

+++?code=src/main/scala/Applicative.scala&lang=scala&title=Applicative

@[3]
@[4-6]
@[7-12]
@[17-30]

---