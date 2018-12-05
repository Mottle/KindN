package kindn.typeclass

trait Show[T] {
	def show(t: T): String
}

object Show {
	def apply[T](implicit instance: Show[T]): Show[T] = instance
}