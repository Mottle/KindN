package kindn.typeclass

trait Ord[T] {
	def moreThan(a: T, b: T): Boolean

	def moreOrEqThan(a: T, b: T): Boolean

	def lessThan(a: T, b: T): Boolean

	def lessOrEqThan(a: T, b: T): Boolean
}

object Ord {
	def apply[T](implicit instance: Ord[T]): Ord[T] = instance
}

