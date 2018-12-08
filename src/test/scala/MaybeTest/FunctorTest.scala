package MaybeTest

import org.scalatest.FlatSpec

import kindn.instance.Maybe._
import kindn.entity.Maybe._
import kindn.typeclass.Functor

class FunctorTest extends FlatSpec {
	"Maybe Functor Test 1" should "be passed" in {
		val numM = Just(1)
		val addOne = (i: Int) => i + 1

		assert(Functor[Maybe].map(numM)(addOne) == Just(2))
	}

	"Maybe Functor Test 2" should "be passed" in {
		val strM = Just("fuck")
		val say = (i: String) => s"say ${i.toString}"

		assert(Functor[Maybe].map(strM)(say) == Just("say fuck"))
	}

	"Maybe Functor Test 3" should "be passed" in {
		val strM = Nothing()
		val say = (i: String) => s"say ${i.toString}"

		assert(Functor[Maybe].map(strM)(say) == Nothing())
	}
}
