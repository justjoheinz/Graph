package graph.geom

import org.scalatest.FunSpec
import graph.geom.util.Precision
import org.scalatest.BeforeAndAfter

class VectorSpec extends FunSpec with BeforeAndAfter {

  implicit val p = Precision(0.00001)

  var v: Vector3D = _

  before {
    v = Vector3D(5, 6, 7)
  }

  describe("A X unit vector") {
    it("should have the length 1.0") {
      assert(Vector3D.X.len === 1.0)
    }
  }
  describe("A Y unit vector") {
    it("should have the length 1.0") {
      assert(Vector3D.Y.len === 1.0)
    }
  }

  describe("A Z unit vector") {
    it("should have the length 1.0") {
      assert(Vector3D.Z.len === 1.0)
    }
  }

  describe("A Vector v") {
    it("should equal the Origin if substracted from itself") {
      assert(v - v === Vector3D.ORIGIN)
    }
    it("should equal zero if multiplied by zero") {
      assert(0 * v === Vector3D.ORIGIN)
    }
    it("should remain equal if -(-v)") {
      assert(-(-v) === v)
    }
  }
}