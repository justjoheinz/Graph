package graph

package object geom {
  import graph.geom.util.Precision
  implicit val p: Precision = new Precision(0.0001)
  implicit def doubleToScalar(d: Double): Scalar = Scalar(d)
}