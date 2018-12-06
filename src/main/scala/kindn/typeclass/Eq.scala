package kindn.typeclass

trait Eq[T] {
	def eq(a: T, b: T): Boolean

	def ueq(a: T, b: T): Boolean
}

object Eq {
	@inline def apply[T](implicit instance: Eq[T]): Eq[T] = instance
}
