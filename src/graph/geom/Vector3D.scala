package graph.geom

import Array._

class Vector3D(val x: Double, val y: Double, val z: Double) {

  def +(v: Vector3D): Vector3D = new Vector3D(x + v.x, y + v.y, z + v.z)

  def -(v: Vector3D): Vector3D = new Vector3D(x - v.x, y - v.y, z - v.z)

  def len(): Double = math.sqrt(x * x + y * y + z * z)

  /** calculate the distance between two vectors imagined as points. */
  def distance(v: Vector3D): Double = (v - Vector3D.this).len

  /** multiplies this vector with a scalar value. */
  def *(scalar: Double): Vector3D = new Vector3D(x * scalar, y * scalar, z * scalar)

  /** returns the unified vector of len == 1 */
  def normalize(): Vector3D = {
    val length: Double = 1.0 / len()
    Vector3D.this.*(length)
  }

  /** calculates the dot product between two vectors. */
  def dot(v: Vector3D): Double = x * v.x + y * v.y + z * v.z

  /** returns the angle in radians between two vectors. */
  def angle(v: Vector3D): Double = math.acos(Vector3D.this.dot(v) / (Vector3D.this.len * v.len))

  def unary_-(): Vector3D = new Vector3D(-x, -y, -z)

  /** defines the cross product between two vectors. */
  def X(v: Vector3D): Vector3D = new Vector3D(y * v.z - v.y * z, z * v.x - v.z * x, x * v.y - v.x * y)

  def toStringRep = x + " " + y + " " + z
  override def toString = "Vector(" + x + ", " + y + ", " + z + ")"
}

object Vector3D {
  val X = new Vector3D(1, 0, 0)
  val Y = new Vector3D(0, 1, 0)
  val Z = new Vector3D(0, 0, 1)
  val ORIGIN = new Vector3D(0, 0, 0)
  val DELTA = 0.0001

  implicit def toArray(v: Vector3D): Array[Double] = Array(v.x, v.y, v.z)

}