package kindn.syntax

import kindn.typeclass.Ord

object Ord {
	implicit class OrdOps[A](a: A) {
		def > (other: A)(implicit ord: Ord[A]): Boolean = ord.moreThan(a, other)
		def < (other: A)(implicit ord: Ord[A]): Boolean = ord.lessThan(a, other)

		def >= (other: A)(implicit ord: Ord[A]): Boolean = ord.moreOrEqThan(a, other)
		def <= (other: A)(implicit ord: Ord[A]): Boolean = ord.lessOrEqThan(a, other)
	}
}
