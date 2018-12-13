package kindn.syntax

import kindn.typeclass.Eq

object Eq {
	implicit class EqOps[A](a: A) {
		def ===(other: A)(implicit eq:Eq[A]): Boolean = eq.eq(a, other)
		def !==(other: A)(implicit eq: Eq[A]): Boolean = eq.ueq(a, other)
	}
}
