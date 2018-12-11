package ListTest

import org.scalatest.FlatSpec
import kindn.typeclass.Monad
import kindn.instance.List._

class MonadTest extends FlatSpec {
	"List Monad Test 1" should "be passed" in {
		val list = 1 :: 2 :: 3 :: 4 :: Nil
		val f: Int => List[Int] = i => List(i + 1)

		assert(Monad[List].flatMap(list)(f) == 2 :: 3 :: 4 :: 5 ::Nil)
	}
}
