package EitherTest

import org.scalatest.FlatSpec

import kindn.instance.Either._
import kindn.typeclass.Show

class ShowTest extends FlatSpec {
	"A Right value" should "display it self" in {
		val r: Either[Int, String] = Right("haha")
		assert(Show[Either[_, _]].show(r) == "Right(haha)")
	}

	"A Left value" should "display it self" in {
		val l: Either[Int, String] = Left(2)
		assert(Show[Either[_, _]].show(l) == "Left(2)")
	}
}
