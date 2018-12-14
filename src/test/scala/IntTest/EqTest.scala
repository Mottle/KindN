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

	"Eq syntax test 1" should "be passed" in {
		val x = 1
		val y = 2

		import kindn.syntax.Eq._

		assert(!(1 <=> 2))
	}

	"Int Eq syntax test 2" should "be passed" in {
		val x = 1
		val y = 2

		import kindn.syntax.Eq._

		assert(1 =!= 2)
	}
}
