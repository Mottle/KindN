package kindn.instance

package object String {
	import kindn.typeclass.{Eq, Show}

	implicit val showInstance: Show[String] = (t: String) => t.toString

	implicit val eqInstance: Eq[String] = new Eq[String] {
		override def eq(a: String, b: String): Boolean = a == b

		override def ueq(a: String, b: String): Boolean = a != b
	}
}
