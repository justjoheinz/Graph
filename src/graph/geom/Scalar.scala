package graph.geom

case class Scalar(self: Double) extends Proxy {

  /** multiplies this vector with a scalar value. */
  def *(v: Vector3D): Vector3D = Vector3D(self * v.x, self * v.y, self * v.z)

  /** scale the mesh by a given factor. */
  def *(m: Mesh): Mesh = {
    Mesh(m.name, m.par.map(this * _).seq)
  }
  /** scale the triangle by a given factor. */
  def *(t: Triangle): Triangle = Triangle(this * t.v1, this * t.v2, this * t.v3)

  def =~=(d2: Double)(implicit p: Precision) = (self - d2).abs <= p.p

}
