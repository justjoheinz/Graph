package graph.geom

import java.io.PrintWriter

case class Mesh(name: Option[String], self: Seq[Triangle]) {

  /** construct an empty mesh. */
  def this() = this(None, Seq.empty)

  /** move each face of the map along the given vector */
  def +(vec: Vector3D): Mesh = {
    self.par.map(_ + vec).seq
  }

  /** scale the mesh by a given factor. */
  def *(scale: Double): Mesh = {
    self.par.map(_ * scale).seq
  }

  def *(matrix: Matrix): Mesh = {
    self.par.map(_ * matrix).seq
  }

  def toSTL = {
    var buffer: StringBuilder = new StringBuilder()
    buffer ++= "solid " + name.getOrElse("untitled")
    buffer ++= "\n"
    self.foreach(t => buffer ++= "facet normal " + t.normalVector.toStringRep + "\n"
      + "outer loop\n"
      + "\tvertex " + t.v1.toStringRep + "\n"
      + "\tvertex " + t.v2.toStringRep + "\n"
      + "\tvertex " + t.v3.toStringRep + "\n"
      + "endloop\n"
      + "endfacet\n")
    buffer ++= "endsolid\n"
    buffer.mkString
  }

}

object Mesh {
  def apply(t: Triangle*): Mesh = Seq(t: _*)

  implicit def toMesh(b: Seq[Triangle]): Mesh = new Mesh(None, b)

  implicit def toBuffer(t: Mesh): Seq[Triangle] = t.self

  def writeAsSTL(m: Mesh, p: PrintWriter): Unit = {
    p.write(m.toSTL)
  }
}