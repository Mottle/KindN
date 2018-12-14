package IntTest

import kindn.instance.Int._
import kindn.typeclass.Ord
import org.scalatest.FlatSpec

class OrdTest extends FlatSpec {
	"A small Int" should "less than a big Int" in {
		val sInt = 1
		val bInt = 2

		assert(Ord[Int].lessThan(sInt, bInt))
	}

	"A small Int or same Int" should "less or same than a Int" in {
		val sInt = 1
		val bInt = 2
		val sameInt = 1

		assert(Ord[Int].lessOrEqThan(sInt, bInt))
		assert(Ord[Int].lessOrEqThan(sInt, sameInt))
	}

	"A big Int" should "more than a big Int" in {
		val sInt = 1
		val bInt = 2

		assert(Ord[Int].moreThan(bInt, sInt))
	}

	"A big Int or same Int" should "more or same than a Int" in {
		val sInt = 1
		val bInt = 2
		val sameInt = 1

		assert(Ord[Int].moreOrEqThan(bInt, sInt))
		assert(Ord[Int].moreOrEqThan(sInt, sameInt))
	}

	"Int Ord syntax test 1" should "be passed" in {
		val x = 1
		val y = 2
		import kindn.syntax.Ord.OrdOps
		assert(OrdOps(1) < 2)
		assert(OrdOps(1) <= 2)
	}
}
