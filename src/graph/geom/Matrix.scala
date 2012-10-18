package graph.geom

import scala.Array._

class Matrix extends Proxy {
  var self = ofDim[Double](3, 3)

  def this(a: Array[Array[Double]]) = {
    this()
    self = a
  }

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

  def apply(i: Int, j: Int) = self(i)(j)

  def update(i: Int, j: Int, v: Double) = self(i)(j) = v

}

object Matrix {

  val UNITY: Matrix = Array.tabulate[Double](3, 3)((n1, n2) => if (n1 == n2) 1.0 else 0.0)

  implicit def toMatrix(a: Array[Array[Double]]): Matrix = new Matrix(a)

  implicit def toArray(m: Matrix): Array[Array[Double]] = m.self
}
