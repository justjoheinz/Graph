package graph.geom

import math._

case class Matrix(val self: Array[Array[Double]]) {

  override def toString = {
    val buffer = new StringBuilder()
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        buffer ++= self(i)(j) + " "
      }
      buffer ++= "\n"
    }
    buffer.mkString
  }

  /** multiply matrix with a vector. */
  def *(v: Vector3D) = {
    Vector3D(
      this(0, 0) * v.x + this(1, 0) * v.y + this(2, 0) * v.z,
      this(0, 1) * v.x + this(1, 1) * v.y + this(2, 1) * v.z,
      this(0, 2) * v.x + this(1, 2) * v.y + this(2, 2) * v.z)
  }

  /** calculate matrix product. */
  def *(m: Matrix) = {
    val r = Array.ofDim[Double](3, 3)
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        for (k <- 0 to 2)
          r(i)(j) = r(i)(j) + this(i)(k) * m(k)(j)
      }
    }
    r
  }

  def apply(i: Int, j: Int) = self(i)(j)

  def update(i: Int, j: Int, v: Double) = self(i)(j) = v

}

object Matrix {

  val UNITY: Matrix = Array.tabulate[Double](3, 3)((n1, n2) => if (n1 == n2) 1.0 else 0.0)

  def rotateX(angle: Double) = Matrix(
    1, 0, 0,
    0, cos(angle), -sin(angle),
    0, sin(angle), cos(angle))

  def rotateY(angle: Double) = Matrix(
    cos(angle), 0, -sin(angle),
    0, 1, 0,
    sin(angle), 0, cos(angle))

  def rotateZ(angle: Double) = Matrix(
    cos(angle), -sin(angle), 0,
    sin(angle), cos(angle), 0,
    0, 0, 1)

  def apply(a00: Double, a01: Double, a02: Double,
    a10: Double, a11: Double, a12: Double,
    a20: Double, a21: Double, a22: Double) = new Matrix(Array(Array(a00, a01, a02), Array(a10, a11, a12), Array(a20, a21, a22)))

  def apply(v1: Vector3D, v2: Vector3D, v3: Vector3D) = new Matrix(Array(v1, v2, v3))

  implicit def toMatrix(a: Array[Array[Double]]): Matrix = new Matrix(a)

  implicit def toArray(m: Matrix): Array[Array[Double]] = m.self
}
