package kindn.instance

package object Int {
	import kindn.typeclass.{Eq, Show, Ord}

	implicit val showInstance: Show[Int] = (t: Int) => t.toString

	implicit val eqInstance: Eq[Int] = new Eq[Int] {
		override def eq(a: Int, b: Int): Boolean = a == b

		override def ueq(a: Int, b: Int): Boolean = a != b
	}

	implicit val ordInstance: Ord[Int] = new Ord[Int] {
		override def moreThan(a: Int, b: Int): Boolean = a > b

		override def moreOrEqThan(a: Int, b: Int): Boolean = a >= b

		override def lessThan(a: Int, b: Int): Boolean = a < b

		override def lessOrEqThan(a: Int, b: Int): Boolean = a <= b
	}
}
