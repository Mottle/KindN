package kindn.instance

package object Double {
	import kindn.typeclass.{Eq, Show, Ord}

	implicit val showInstance: Show[Double] = (t: Double) => t.toString

	implicit val eqInstance: Eq[Double] = new Eq[Double] {
		override def eq(a: Double, b: Double): Boolean = a == b

		override def ueq(a: Double, b: Double): Boolean = a != b
	}

	implicit val ordInstance: Ord[Double] = new Ord[Double] {
		override def moreThan(a: Double, b: Double): Boolean = a > b

		override def moreOrEqThan(a: Double, b: Double): Boolean = a >= b

		override def lessThan(a: Double, b: Double): Boolean = a < b

		override def lessOrEqThan(a: Double, b: Double): Boolean = a <= b
	}
}
