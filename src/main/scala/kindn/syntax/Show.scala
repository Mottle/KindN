package kindn.syntax

import kindn.typeclass.Show

object Show {
	implicit class ShowOps[A](a: A) {
		def show(implicit show: Show[A]): String = show.show(a)
	}
}
