package graph.geom
import math.abs

case class Plane(point: Vector3D, normal: Vector3D) {

  def isInPlane(r: Vector3D): Boolean = abs(normal * (r - point)) <= GraphConst.DELTA
  def isInPlane(s: Segment): Boolean = isInPlane(s.direction)

  def distance(p: Vector3D) = (p - point) * normal / normal.len

  /**
   * move plane d units along the normal vector
   */
  def +(d: Double): Plane = Plane(point + (normal.normalize) * d, normal)

  /**
   * move plane d units along the normal vector
   */
  def -(d: Double): Plane = Plane(point - (normal.normalize) * d, normal)
}

object Plane {
  implicit def toPlane(t: Triangle) = Plane(t.v1, t.normalVector)
}