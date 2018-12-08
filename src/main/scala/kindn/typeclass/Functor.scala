package kindn.typeclass

import scala.languageFeature.higherKinds

trait Functor[F[_]] {
	def map[A, B](fa: F[A])(f: A => B): F[B]

	def lift[A, B](f: A => B): F[A] => F[B] = map(_)(f)
}

object Functor {
	def apply[F[_]](implicit instance: Functor[F]): Functor[F] = instance
}