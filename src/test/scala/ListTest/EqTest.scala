package ListTest

import kindn.instance.List._
import kindn.typeclass.Eq
import org.scalatest.FlatSpec

class EqTest extends FlatSpec {
	"A List" should "eq to the same one" in {
		val list1 = List(1,2)
		val list2 = List(1,2)

		assert(Eq[List[_]].eq(list1, list2))
	}

	"A List" should "ueq to the different one" in {
		val list1 = List(1,2)
		val list2 = List(1,2,3)

		assert(Eq[List[_]].ueq(list1, list2))
	}
}
