package graph.geom

import org.junit.Test
import org.junit.Assert._
import org.junit.Test

class VectorTest {

  val scalar = 2.0

  @Test def lenX() = {
    assertTrue("Unit vector has length 1.0", Vector3D.X.len =~= 1.0)
  }
  @Test def lenY() = {
    assertTrue("Unit vector has length 1.0", Vector3D.Y.len =~= 1.0)
  }
  @Test def lenZ() = {
    assertTrue("Unit vector has length 1.0", Vector3D.Z.len =~= 1.0)
  }
  @Test def originX = {
    assertTrue(Vector3D.ORIGIN.x =~= 0)
  }
  @Test def originY = {
    assertTrue(Vector3D.ORIGIN.y =~= 0)
  }
  @Test def originZ = {
    assertTrue(Vector3D.ORIGIN.z =~= 0)
  }
  @Test def scaleX = {
    assertTrue((scalar * Vector3D.X).x =~= 2.0)
  }
  @Test def scaleY = {
    assertTrue((scalar * Vector3D.Y).y =~= 2.0)
  }
  @Test def scaleZ = {
    assertTrue((scalar * Vector3D.Z).z =~= 2.0)
  }

  @Test def angle1 = {
    assertTrue(math.toDegrees(Vector3D.X.angle(Vector3D.Y)) =~= 90.0)
  }

  @Test def inverse =
    assertTrue(-(Vector3D.X).x =~= -1.0)

}