package graph.geom

import scala.math.acos

/** A Vector class to represent a 3D vector consisting of a coordinate with x,y and z values. */
case class Vector3D(x: Double, y: Double, z: Double) {

  def +(v: Vector3D) = Vector3D(x + v.x, y + v.y, z + v.z)

  def -(v: Vector3D) = Vector3D(x - v.x, y - v.y, z - v.z)

  def len = math.sqrt(x * x + y * y + z * z)

  /** calculate the distance between two vectors imagined as points. */
  def distance(v: Vector3D) = (v - this).len

  /** returns the unified vector of len == 1 */
  def normalize = {
    val length = 1.0 / len
    length * this
  }

  /** calculates the dot product between two vectors. */
  def *(v: Vector3D): Double = x * v.x + y * v.y + z * v.z

  /** returns the angle in radians between two vectors. */
  def angle(v: Vector3D) = acos(this * v / (len * v.len))

  /** return the inverse vector. */
  def unary_-() = Vector3D(-x, -y, -z)

  /** defines the cross product between two vectors. */
  def X(v: Vector3D) = Vector3D(y * v.z - v.y * z, z * v.x - v.z * x, x * v.y - v.x * y)

  def toStringRep = x + " " + y + " " + z
  override def toString = "Vector(" + x + ", " + y + ", " + z + ")"
}

object Vector3D {
  val X = Vector3D(1, 0, 0)
  val Y = Vector3D(0, 1, 0)
  val Z = Vector3D(0, 0, 1)
  val ORIGIN = Vector3D(0, 0, 0)

  implicit def toVector(v: (Double, Double, Double)): Vector3D = Vector3D(v._1, v._2, v._3)
  implicit def toArray(v: Vector3D): Array[Double] = Array(v.x, v.y, v.z)

}