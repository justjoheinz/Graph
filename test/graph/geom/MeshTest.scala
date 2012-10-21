package graph.geom

import scala.collection.mutable.ArrayBuffer
import org.junit.Test
import org.junit.Assert._
import java.io.PrintWriter
import java.io.File
import Mesh.toBuffer
import org.junit.Test

class MeshTest {

  val t: Triangle = new Triangle(Vector3D.X, Vector3D.Y, Vector3D.ORIGIN)
  val emptyMesh: Mesh = Seq.empty
  val m: Mesh = Seq(t, new Triangle(Vector3D.X, Vector3D.Z, Vector3D.ORIGIN))

  @Test def transform = {
    val result: Mesh = Seq(t + Vector3D.X, new Triangle(Vector3D.X, Vector3D.Z, Vector3D.ORIGIN) + Vector3D.X)
    assertEquals(result, m + Vector3D.X)
  }

  @Test def sizeTest = {
    assertEquals(2, m.size)
  }

  @Test def stlwrite = {
    println(m.toSTL)
  }

  @Test def stlwrite2 = {
    val p = new PrintWriter(new File("test.stl"))
    p.print(m.toSTL)
    p.close()
  }
}