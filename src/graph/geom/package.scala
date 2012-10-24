package graph

package object geom {
  implicit val p: Precision = new Precision(0.0001)
  implicit def doubleToScalar(d: Double): Scalar = Scalar(d)
}