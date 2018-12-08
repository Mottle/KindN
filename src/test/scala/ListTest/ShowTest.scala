package ListTest

import kindn.instance.List._
import kindn.typeclass.Show
import org.scalatest.FlatSpec

class ShowTest extends FlatSpec {
	"A List" should "show itself" in {
		val list = List(1,2,3,4)

		assert(Show[List[_]].show(list) == list.toString())
	}
}
