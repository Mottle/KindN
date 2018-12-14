package ListTest

import org.scalatest.FlatSpec
import kindn.typeclass.Applicative
import kindn.instance.List._

class ApplicativeTest extends FlatSpec{
	"List Applicative Test 1" should "be passed" in {
		val list = 1 :: Nil
		val list1 = Applicative[List].pure(1)
		assert(list == list1)
	}

	"List Applicative Test 2" should "be passed" in {
		val f1: Int => Int = 1 + _
		val f2: Int => Int = 2 * _
		val fs = f1 :: f2 :: Nil

		val list = 1 :: 2 :: 3 :: 4 :: Nil
		val result = Applicative[List].ap(list)(fs)
		assert(result == 2 :: 3 :: 4 :: 5 :: 2 :: 4 :: 6 :: 8 :: Nil)
	}

	"List Applicative test 1" should "be passed" in {
		val list = 1 :: 2 :: 3 :: Nil
		val fList: List[Int => Int] = ((i: Int) => i + 1) :: ((i: Int) => i * 2) :: Nil
		import kindn.syntax.Applicative._

		val res = list.ap(fList)
		assert(res == 2 :: 3 :: 4 :: 2 :: 4 :: 6 :: Nil)
	}
}
