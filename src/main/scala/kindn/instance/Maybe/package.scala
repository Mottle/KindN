package kindn.instance

import kindn.typeclass.Applicative

package object Maybe {
	import kindn.entity.Maybe._
	import kindn.typeclass.Show

	implicit val showInstance: Show[Maybe[_]] = {
		case Just(value) => s"Just(${value.toString})"
		case Nothing() => "Nothing"
	}

	import kindn.typeclass.Eq

	implicit val EqInstance: Eq[Maybe[_]] = new Eq[Maybe[_]] {
		override def eq(a: Maybe[_], b: Maybe[_]): Boolean = (a, b) match {
			case (Just(v1), Just(v2)) => v1 == v2
			case (Nothing(), Nothing()) => true
			case _ => false
		}

		override def ueq(a: Maybe[_], b: Maybe[_]): Boolean = !this.eq(a, b)
	}

	import kindn.typeclass.Functor

	implicit val FunctorInstance: Functor[Maybe] = new Functor[Maybe] {
		override def map[A, B](fa: Maybe[A])(f: A => B): Maybe[B] = fa match {
			case Nothing() => Nothing()
			case Just(value) => Just(f(value))
		}
	}

	implicit val ApplicativeInstance: Applicative[Maybe] = new Applicative[Maybe] {
		override def pure[A](a: A): Maybe[A] = if(a != null) Just(a) else Nothing()

		override def ap[A, B](fa: Maybe[A])(f: Maybe[A => B]): Maybe[B] = fa match {
			case Nothing() => Nothing()
			case Just(value) => f match {
				case Nothing() => Nothing()
				case Just(fn) => pure(fn(value))
			}
		}


		override def map[A, B](fa: Maybe[A])(f: A => B): Maybe[B] = FunctorInstance.map(fa)(f)
	}

	import kindn.typeclass.Monad

	implicit val MonadInstance: Monad[Maybe] = new Monad[Maybe] {
		override def flatMap[A, B](fa: Maybe[A])(f: A => Maybe[B]): Maybe[B] = fa match {
			case Just(value) => f(value)
			case Nothing() => Nothing()
		}

		override def pure[A](a: A): Maybe[A] = ApplicativeInstance.pure(a)

		override def ap[A, B](fa: Maybe[A])(f: Maybe[A => B]): Maybe[B] = ApplicativeInstance.ap(fa)(f)

		override def map[A, B](fa: Maybe[A])(f: A => B): Maybe[B] = FunctorInstance.map(fa)(f)
	}
}
