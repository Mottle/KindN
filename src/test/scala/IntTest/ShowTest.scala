package IntTest

import org.scalatest.FlatSpec

import kindn.typeclass.Show
import kindn.instance.Int._

class ShowTest extends FlatSpec{
	"A Int value" should "display itself" in {
		val a = 1
		assert(Show[Int].show(a) == "1")

		val b = 123
		assert(Show[Int].show(b) == "123")
	}
}
