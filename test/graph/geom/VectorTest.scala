package graph.geom

import org.junit.Test
import org.junit.Assert._
import org.junit.Test

class VectorTest {

  val scalar = 2.0

  @Test def lenX() = {
    assertEquals("Unit vector has length 1.0", Vector3D.X.len, 1.0, GraphConst.DELTA)
  }
  @Test def lenY() = {
    assertEquals("Unit vector has length 1.0", Vector3D.Y.len, 1.0, GraphConst.DELTA)
  }
  @Test def lenZ() = {
    assertEquals("Unit vector has length 1.0", Vector3D.Z.len, 1.0, GraphConst.DELTA)
  }
  @Test def originX = {
    assertEquals(Vector3D.ORIGIN.x, 0, GraphConst.DELTA)
  }
  @Test def originY = {
    assertEquals(Vector3D.ORIGIN.y, 0, GraphConst.DELTA)
  }
  @Test def originZ = {
    assertEquals(Vector3D.ORIGIN.z, 0, GraphConst.DELTA)
  }
  @Test def scaleX = {
    assertEquals((scalar * Vector3D.X).x, 2.0, GraphConst.DELTA)
  }
  @Test def scaleY = {
    assertEquals((scalar * Vector3D.Y).y, 2.0, GraphConst.DELTA)
  }
  @Test def scaleZ = {
    assertEquals((scalar * Vector3D.Z).z, 2.0, GraphConst.DELTA)
  }

  @Test def angle1 = {
    assertEquals(math.toDegrees(Vector3D.X.angle(Vector3D.Y)), 90.0, GraphConst.DELTA)
  }

  @Test def inverse =
    assertEquals(-(Vector3D.X).x, -1.0, GraphConst.DELTA)

}