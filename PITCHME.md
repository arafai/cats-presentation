## A gentle introduction to category theory using Cats


---


@title[Category theory #1]

### Abstraction
### Composition
### Identity

Note:
Abstraction - getting rid of some unnecessary details => objects become identical
Composition is the essence 
Composition & identity - arguably they define category theory



---


@title[Category theory #2]

### Objects
### Morphisms

Note:
Category is a bunch of objects + morphisms
An object - has no property, no structure.
Morphism - no property except that is has a beginning and an end
A category could be considered as a graph, 1 or multiple arrows between 2 nodes, both ways
All morphism could be considered as a multiplication table (all the information)


---?image=https://raw.githubusercontent.com/arafai/cats-presentation/master/assets/image/category.svg&size=auto 50%

<span style="color:gray; font-size:1.5em; color:black; margin-top: -30%; display:block;"><b>Category</b></span>

Note:
The category laws are:

---?image=https://raw.githubusercontent.com/arafai/cats-presentation/master/assets/image/category_composition.svg&size=auto 50%

<span style="color:gray; font-size:1.5em; color:black; margin-top: -30%; display:block;"><b>Composition</b></span>


---?image=https://raw.githubusercontent.com/arafai/cats-presentation/master/assets/image/category_identity.svg&size=auto 50%

<span style="color:gray; font-size:1.5em; color:black; margin-top: -30%; display:block;"><b>Identity</b></span>

---?image=https://raw.githubusercontent.com/arafai/cats-presentation/master/assets/image/category_associativity.svg&size=auto 50%

<span style="color:gray; font-size:1.5em; color:black; margin-top: -30%; display:block;"><b>Associativity</b></span>

---


Example of categories: 
* category with no objects  
* category with 1 object - Monoid
* set category
* orders category  
* category of types and function between types


---?image=https://raw.githubusercontent.com/arafai/cats-presentation/master/assets/image/monoid.svg&size=auto 50%

<span style="color:gray; font-size:1.5em; color:black; margin-top: -30%; display:block;"><b>Monoid</b></span>

Note:
Addition (0 as empty, morphism adding +1, + 2), multiplication
String concatenation ( not commutative )


---

#### Monoid typeclass

+++?code=src/main/scala/Monoid.scala&lang=scala&title=Monoid

@[1-5]
@[8]
@[10-11]
@[13-14]


---

#### Semigroup typeclass

+++?code=src/main/scala/Semigroup.scala&lang=scala&title=Semigroup

@[1-4]
@[6]
@[8-9]


---?image=https://raw.githubusercontent.com/arafai/cats-presentation/master/assets/image/functor.svg&size=auto 50%

<span style="color:gray; font-size:1.5em; color:black; margin-top: -30%; display:block;"><b>Functor</b></span>

Note:
Show code after this one

A functor is a mapping between categories. 
Given two categories, C and D, a functor F maps objects in C to objects in D — it’s a function on objects.
If a is an object in C, we’ll write its image in D as F a (no parentheses).
But a category is not just objects — it’s objects and morphisms that connect them.
A functor also maps morphisms — it’s a function on morphisms. But it doesn’t map morphisms willy-nilly —
it preserves connections. So if a morphism f in C connects object a to object b, f :: a -> b
the image of f in D, F f, will connect the image of a to the image of b, F f :: F a -> F b.
As you can see, a functor preserves the structure of a category: what’s connected in one category will 
be connected in the other category. 
But there’s something more to the structure of a category: there’s also the composition of morphisms and the 
identity -  Functors must preserve the structure of a category. 

---

#### Functor typeclass

+++?code=src/main/scala/Functor.scala&lang=scala&title=Functor

@[1-4]
@[6]
@[8-9]
@[11-12]


Note:
Show code after this one

---

#### Applicative typeclass

+++?code=src/main/scala/Applicative.scala&lang=scala&title=Applicative

@[1]
@[3-5]
@[7-12]
@[15]
@[17-18]
@[20-21]
@[23-24]

Note:
Show code after this one

---

#### Monad typeclass

+++?code=src/main/scala/Monad.scala&lang=scala&title=Monad

@[1]
@[3-5]
@[7-8]
@[11]
@[13-14]
@[15-17]
@[19-20]


Note:
Show code after this one


---?image=http://adit.io/imgs/functors/recap.png&size=auto 30%


---

```scala

def map[A, B](fa: F[A])(f: A => B): F[B]

def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]

def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

```

---

#### Credits

 [Bartosz Milewski's Programming Cafe](https://bartoszmilewski.com)
 [Cats project](https://typelevel.org/cats/)
 [Advanced scala with cats](https://underscore.io/training/courses/advanced-scala/)
 [Visual stuff for functors, applicative and monads](http://adit.io/posts/2013-04-17-functors,_applicatives,_and_monads_in_pictures.html)
 [eed3si9n.com/herding-cats](Herding cats)
