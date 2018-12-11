package kindn.instance

package object List {
	import kindn.typeclass.Show

	implicit val showInstance: Show[List[_]] = (t: List[_]) => t.toString()

	import kindn.typeclass.Functor

	implicit val functorInstance: Functor[List] = new Functor[List] {
		override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
	}

	import kindn.typeclass.Eq

	implicit val eqInstance: Eq[List[_]] = new Eq[List[_]] {
		override def eq(a: List[_], b: List[_]): Boolean = a == b

		override def ueq(a: List[_], b: List[_]): Boolean = a != b
	}

	import kindn.typeclass.Applicative

	implicit val applicativeInstance: Applicative[List] = new Applicative[List] {
		override def pure[A](a: A): List[A] = a :: Nil

		override def ap[A, B](fa: List[A])(f: List[A => B]): List[B] = f.flatMap(_f => fa.map(_f))

		override def map[A, B](fa: List[A])(f: A => B): List[B] = functorInstance.map(fa)(f)
	}

	import kindn.typeclass.Monad

	implicit val monadInstance: Monad[List] = new Monad[List] {
		override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f(_))

		override def pure[A](a: A): List[A] = applicativeInstance.pure(a)

		override def ap[A, B](fa: List[A])(f: List[A => B]): List[B] = applicativeInstance.ap(fa)(f)

		override def map[A, B](fa: List[A])(f: A => B): List[B] = functorInstance.map(fa)(f)
	}
}
