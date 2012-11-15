package graph.geom

import org.junit.Test
import org.junit.Assert._
import org.junit.Test
import graph.geom.util.Precision

class TriangleTest {

  implicit val p = Precision(0.0001)
  val v1 = new Vector3D(2, 0, 0)
  val v2 = new Vector3D(0, 3, 0)
  val v3 = new Vector3D(0, 0, 5)

  val t = new Triangle(v1, v2, v3)
  val t2 = new Triangle(Vector3D.X, Vector3D.Y, Vector3D.ORIGIN)

  @Test def area = assertTrue(19.0 / 2.0 =~= t.area)

  @Test def isInPlane1 = assertTrue(t2.isInPlane(new Vector3D(2, 2, 0)))
  @Test def isInPlane2 = assertFalse(t2.isInPlane(new Vector3D(2, 2, 2)))

}