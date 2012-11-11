package graph.geom

/** A plane in 3D space represented by a point in the plane and a normal vector. */
case class Plane(point: Vector3D, normal: Vector3D) {
  import Scalar._
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