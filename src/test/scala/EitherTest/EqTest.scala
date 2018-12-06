package EitherTest

import org.scalatest.FlatSpec

import kindn.instance.Either._
import kindn.typeclass.Eq

class EqTest extends FlatSpec {
	"A either value" should "eq with the same one" in {
		val r1 = Right("a")
		val r2 = Right("a")

		assert(Eq[Either[_, _]].eq(r1, r2))

		val l1 = Left(1)
		val l2 = Left(1)

		assert(Eq[Either[_, _]].eq(l1, l2))
	}

	"A either value" should "ueq with different one" in {
		val r1 = Right("a")
		val r2 = Right("b")

		assert(Eq[Either[_, _]].ueq(r1, r2))

		val l1 = Left(1)
		val l2 = Left(2)

		assert(Eq[Either[_, _]].ueq(l1, l2))
	}
}
