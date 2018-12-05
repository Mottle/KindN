package kindn.entity

package object Either {
	trait Either[T, R]

	case class Left[T, R](value: T) extends Either[T, R]
	case class Right[T, R](value: R) extends Either[T, R]
}
