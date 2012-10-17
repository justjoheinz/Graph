import scala.collection.mutable.ArrayBuffer
import org.junit.Test
import org.junit.Assert._

class MeshTest {

  val emptyMesh: Mesh = new Mesh("", ArrayBuffer.empty[Triangle])

  val t: Triangle = new Triangle(Vector3D.X, Vector3D.Y, Vector3D.ORIGIN)

  @Test def transform =
    assertEquals(emptyMesh, emptyMesh.transform(Vector3D.X))

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
    println(Mesh.writeAsSTL(m))
  }
}