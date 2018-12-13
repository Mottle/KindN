package kindn.syntax

import kindn.typeclass.Applicative

object Applicative {
	implicit class ApplicativeOps[A, F[_]](fa: F[A]) {
		def ap[B](f: F[A => B])(implicit applicative: Applicative[F]): F[B] = applicative.ap(fa)(f)
	}
}
