

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.StringBuilder

class Mesh(val name: String, val self: ArrayBuffer[Triangle]) extends Proxy {

  /** construct an empty mesh. */
  def this() = this("", ArrayBuffer.empty[Triangle])

  /** move each face of the map along the given vector */
  def transform(vec: Vector3D): Mesh = {
    this.map(_ + vec)
  }

}

object Mesh {
  def apply(t: Triangle*): Mesh = ArrayBuffer(t: _*)

  implicit def toMesh(b: ArrayBuffer[Triangle]): Mesh = new Mesh("", b)

  implicit def toBuffer(t: Mesh): ArrayBuffer[Triangle] = t.self

  def writeAsSTL(m: Mesh): String = {
    var buffer: String = new String()
    buffer += "solid unknown\n"
    m.foreach(t => buffer += "facet normal " + t.normalVector.toStringRep + "\n"
      + "outer loop\n"
      + "\tvertex " + t.v1.toStringRep + "\n"
      + "\tvertex " + t.v2.toStringRep + "\n"
      + "\tvertex " + t.v3.toStringRep + "\n"
      + "endloop\n")
    buffer += "endfacet\n"
    buffer += "endsolid\n"
    buffer
  }
}