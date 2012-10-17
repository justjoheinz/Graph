

import scala.collection.mutable.ArrayBuffer

class Mesh(val name: String, val self: ArrayBuffer[Triangle]) extends Proxy {

  /** move each face of the map along the given vector */
  def transform(vec: Vector3D): Mesh = {
    this.map(_ + vec)
  }

}

object Mesh {
  def apply(t: Triangle*): Mesh = ArrayBuffer(t: _*)

  implicit def toMesh(b: ArrayBuffer[Triangle]): Mesh = new Mesh("", b)

  implicit def toBuffer(t: Mesh): ArrayBuffer[Triangle] = t.self
}