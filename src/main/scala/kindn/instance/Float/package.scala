package kindn.instance

package object Float {
	import kindn.typeclass.{Eq, Show, Ord}

	implicit val showInstance: Show[Float] = (t: Float) => t.toString

	implicit val eqInstance: Eq[Float] = new Eq[Float] {
		override def eq(a: Float, b: Float): Boolean = a == b

		override def ueq(a: Float, b: Float): Boolean = a != b
	}

	implicit val ordInstance: Ord[Float] = new Ord[Float] {
		override def moreThan(a: Float, b: Float): Boolean = a > b

		override def moreOrEqThan(a: Float, b: Float): Boolean = a >= b

		override def lessThan(a: Float, b: Float): Boolean = a < b

		override def lessOrEqThan(a: Float, b: Float): Boolean = a <= b
	}
}
