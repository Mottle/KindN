package kindn.instance

package object Either {
	import kindn.typeclass.{Eq, Show}

	implicit val eqInstance: Eq[Either[_, _]] = new Eq[Either[_, _]] {
		override def eq(a: Either[_, _], b: Either[_, _]): Boolean = a == b

		override def ueq(a: Either[_, _], b: Either[_, _]): Boolean = a != b
	}

	implicit val showInstance: Show[Either[_, _]] = {
		case Left(value) => s"Left(${value.toString})"
		case Right(value) => s"Right(${value.toString})"
	}
}
