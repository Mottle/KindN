package kindn.syntax

import kindn.typeclass.Functor

object Functor {
	implicit class FunctorOps[A, F[_]](fa: F[A]) {
		def map[B](f: A => B)(implicit functor: Functor[F]): F[B] = functor.map(fa)(f)
		def >>[B](f: A => B)(implicit functor: Functor[F]): F[B] = functor.map(fa)(f)
	}
}
