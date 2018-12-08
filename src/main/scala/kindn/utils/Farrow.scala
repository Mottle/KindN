package kindn.utils

object Farrow {
	implicit class Farrow[A, B](a: A) {
		def |>(f: A => B): B = f(a)
	}
}