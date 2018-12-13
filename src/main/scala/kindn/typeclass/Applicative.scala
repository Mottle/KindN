package kindn.typeclass

trait Applicative[F[_]] extends Functor[F] {
	def pure[A](a: A): F[A]
	def ap[A, B](fa: F[A])(f: F[A => B]): F[B]
}

object Applicative {
	def apply[F[_]](implicit instance: Applicative[F]): Applicative[F] = instance
}
