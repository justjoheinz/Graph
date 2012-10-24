package graph.geom

case class Plane(point: Vector3D, normal: Vector3D) {

  def isInPlane(r: Vector3D) = (0.0) =~= (normal * (r - point))
  def isInPlane(s: Segment): Boolean = isInPlane(s.direction)

  def distance(p: Vector3D) = (p - point) * normal / normal.len

  /**
   * move plane d units along the normal vector
   */
  def +(d: Scalar): Plane = Plane(point + d * (normal.normalize), normal)

  /**
   * move plane d units along the normal vector
   */
  def -(d: Scalar): Plane = Plane(point - d * (normal.normalize), normal)
}

object Plane {
  implicit def toPlane(t: Triangle) = Plane(t.v1, t.normalVector)
}