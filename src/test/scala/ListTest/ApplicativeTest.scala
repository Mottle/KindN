package ListTest

import org.scalatest.FlatSpec
import kindn.typeclass.Applicative
import kindn.instance.List._

class ApplicativeTest extends FlatSpec{
	"List Applicative Test 1" should "be passed" in {
		val f1: Int => Int = 1 + _
		val f2: Int => Int = 2 * _
		val fs = f1 :: f2 :: Nil

		val list = 1 :: 2 :: 3 :: 4 :: Nil
		val result = Applicative[List].ap(list)(fs)
		assert(result == 2 :: 3 :: 4 :: 5 :: 2 :: 4 :: 6 :: 8 :: Nil)
	}
}
