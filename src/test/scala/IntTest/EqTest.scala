package IntTest

import org.scalatest.FlatSpec
import kindn.instance.Int._
import kindn.typeclass.Eq


class EqTest extends FlatSpec {
	"Two same Int" should "be eq" in {
		val a = 1
		val b = 1
		assert(Eq[Int].eq(a, b))
	}

	"Two different Int" should "not be eq" in {
		val a = 1
		val b = 2
		assert(!Eq[Int].eq(a, b))
	}
}
