package graph

package object geom {
  import graph.geom.util.Precision
  implicit def doubleToScalar(d: Double): Scalar = Scalar(d)
}