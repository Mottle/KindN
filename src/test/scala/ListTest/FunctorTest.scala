package ListTest

import org.scalatest.FlatSpec
import kindn.instance.List._
import kindn.typeclass.Functor


class FunctorTest extends FlatSpec {
	"List Functor Test 1" should "be passed" in {
		val list1 = List(1,2,3,4)
		val addOne = (i: Int) => i + 1

		assert(Functor[List].map(list1)(addOne) == List(2,3,4,5))
	}

	"List Functor Test 2" should "be passed" in {
		val list1 = List(1,2,3,4)
		val timesThree = (i: Int) => i * 3

		assert(Functor[List].map(list1)(timesThree) == list1.map(timesThree))
	}
}
