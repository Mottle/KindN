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
}
