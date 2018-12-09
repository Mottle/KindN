package MaybeTest

import org.scalatest.FlatSpec
import kindn.entity.Maybe._
import kindn.instance.Maybe._
import kindn.typeclass.Applicative

class ApplicativeTest extends FlatSpec {
	"Maybe Applicative Test 1" should "be passed" in {
		val m1 = Applicative[Maybe].pure(12)
		val m2 = Applicative[Maybe].pure(null)

		assert(m1 == Just(12))
		assert(m2 == Nothing())
	}

	"Maybe Applicative Test 2" should "be passed" in {
		val m1 = Just(12)
		val m2 = Nothing[Int]()

		val f = Just((i: Int) => i + 1)

		assert(Applicative[Maybe].ap(m1)(f) == Just(13))
		assert(Applicative[Maybe].ap(m2)(f) == Nothing())
	}
}
