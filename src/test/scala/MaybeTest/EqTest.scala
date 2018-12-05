package MaybeTest

import org.scalatest.FlatSpec

import kindn.instance.Maybe._
import kindn.entity.Maybe._
import kindn.typeclass.Eq

class EqTest extends FlatSpec {
	"The same Maybe instances equal each other" should "return true" in {
		val m1 = Just(1)
		val m2 = Just(1)

		val m3 = Nothing[Int]()
		val m4 = Nothing[Int]()

		assert(Eq[Maybe[_]].eq(m1, m2))
		assert(Eq[Maybe[_]].eq(m3, m4))
	}
}
