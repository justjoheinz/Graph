import scala.collection.mutable.ArrayBuffer
import org.junit.Test
import org.junit.Assert._

class MeshTest {

  val emptyMesh: Mesh = new Mesh("", ArrayBuffer.empty[Triangle])

  @Test def transform =
    assertEquals(emptyMesh, emptyMesh.transform(Vector3D.X))
}