package graph.geom

import math.abs
import graph.geom.util.Precision

/** A line segment represented by two vectors denoting the end points of the segment. */
case class Segment(p1: Vector3D, p2: Vector3D) {

  def len = direction.len

  def direction = { (p2 - p1) }

  def perpendicular(s: Segment)(implicit p: Precision) = (direction * s.direction) =~= 0.0

}

object Segment {
  implicit def vector3dToSegment(v: Vector3D): Segment = Segment(Vector3D.ORIGIN, v)
}