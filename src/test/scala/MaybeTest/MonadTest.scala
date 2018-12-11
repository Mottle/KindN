package MaybeTest

import kindn.entity.Maybe._
import org.scalatest.FlatSpec
import kindn.instance.Maybe._
import kindn.typeclass.Monad

class MonadTest extends FlatSpec {
	"Maybe Monad Test 1" should "be passed" in {
		val maybe1 = Just(1)
		val f = (i: Int) => Just(i + 1)

		assert(Monad[Maybe].flatMap(maybe1)(f) == Just(2))
	}
}
