package kindn.syntax

import kindn.typeclass.Monad

object Monad {
	implicit class MonadOps[A, F[_]](fa: F[A]) {
		def flatMap[B](f: A => F[B])(monad: Monad[F]): F[B] = monad.flatMap(fa)(f)
		def >>=[B](f: A => F[B])(monad: Monad[F]): F[B] = monad.flatMap(fa)(f)
	}
}
