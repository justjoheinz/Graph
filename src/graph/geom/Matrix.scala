package graph.geom

import scala.Array._

class Matrix(val self: Array[Array[Double]]) {

  def this(a00: Double, a01: Double, a02: Double,
    a10: Double, a11: Double, a12: Double,
    a20: Double, a21: Double, a22: Double) = {
    this(Array(Array(a00, a01, a02), Array(a10, a11, a12), Array(a20, a21, a22)))
  }

  def this(v1: Vector3D, v2: Vector3D, v3: Vector3D) = {
    this(Array(v1, v2, v3))
  }

  def this() = this(0, 0, 0, 0, 0, 0, 0, 0, 0)

  override def toString() = {
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
  def *(v: Vector3D): Vector3D = {
    new Vector3D(
      this(0, 0) * v.x + this(1, 0) * v.y + this(2, 0) * v.z,
      this(0, 1) * v.x + this(1, 1) * v.y + this(2, 1) * v.z,
      this(0, 2) * v.x + this(1, 2) * v.y + this(2, 2) * v.z)
  }

  def *(m: Matrix): Matrix = {
    val r: Matrix = Matrix.UNITY
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        r(i)(j) = 0
        for (k <- 0 to 2)
          r(i)(j) += this(i)(k) * m(k)(j)
      }
    }
    r
  }

  def apply(i: Int, j: Int) = self(i)(j)

  def update(i: Int, j: Int, v: Double) = self(i)(j) = v

}

object Matrix {

  val UNITY: Matrix = Array.tabulate[Double](3, 3)((n1, n2) => if (n1 == n2) 1.0 else 0.0)

  def rotateX(angle: Double): Matrix = new Matrix(
    1, 0, 0,
    0, math.cos(angle), -math.sin(angle),
    0, math.sin(angle), math.cos(angle))

  def rotateY(angle: Double): Matrix = new Matrix(
    math.cos(angle), 0, -math.sin(angle),
    0, 1, 0,
    math.sin(angle), 0, math.cos(angle))

  def rotateZ(angle: Double): Matrix = new Matrix(
    math.cos(angle), -math.sin(angle), 0,
    math.sin(angle), math.cos(angle), 0,
    0, 0, 1)

  implicit def toMatrix(a: Array[Array[Double]]): Matrix = new Matrix(a)

  implicit def toArray(m: Matrix): Array[Array[Double]] = m.self
}
