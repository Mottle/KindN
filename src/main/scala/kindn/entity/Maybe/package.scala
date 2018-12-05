package kindn.entity

package object Maybe {
	trait Maybe[T]

	case class Just[T](value: T) extends Maybe[T]
	case class Nothing[T]() extends Maybe[T]
}