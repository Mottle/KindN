package kindn.instance

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
}
