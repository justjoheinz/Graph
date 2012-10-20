package graph.geom

import scala.collection.mutable.ArrayBuffer
import org.junit.Test
import org.junit.Assert._
import java.io.PrintWriter
import java.io.File
import Mesh.toBuffer
import org.junit.Test

class MeshTest {

  val emptyMesh: Mesh = Mesh("", ArrayBuffer.empty[Triangle])

  val t: Triangle = new Triangle(Vector3D.X, Vector3D.Y, Vector3D.ORIGIN)

  @Test def transform =
    assertEquals(emptyMesh, emptyMesh + Vector3D.X)

  @Test def sizeTest = {
    var m = emptyMesh
    m += t
    m += new Triangle(Vector3D.X, Vector3D.Z, Vector3D.ORIGIN)
    assertEquals(2, m.size)
  }

  @Test def stlwrite = {
    var m = emptyMesh
    m += t
    m += new Triangle(Vector3D.X, Vector3D.Z, Vector3D.ORIGIN)
    println(m.toSTL)
  }

  @Test def stlwrite2 = {
    var m = emptyMesh
    m += t
    m += new Triangle(Vector3D.X, Vector3D.Z, Vector3D.ORIGIN)
    val p = new PrintWriter(new File("test.stl"))
    println(Mesh.writeAsSTL(m, p))
  }
}