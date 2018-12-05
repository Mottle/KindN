package MaybeTest

import org.scalatest.FlatSpec

import kindn.instance.Maybe._
import kindn.entity.Maybe._
import kindn.typeclass.Show

class ShowTest extends FlatSpec {
	"An Maybe Int value" should "show it's value with type" in {
		val m1 = Just(1)
		val m2 = Nothing()

		assert(Show[Maybe[_]].show(m1) == "Just(1)")
		assert(Show[Maybe[_]].show(m2) == "Nothing")
	}

	"An Maybe String value" should "show it self with type" in {
		val m1 = Just("Haha")
		val m2 = Nothing()

		assert(Show[Maybe[_]].show(m1) == "Just(Haha)")
		assert(Show[Maybe[_]].show(m2) == "Nothing")
	}

}
