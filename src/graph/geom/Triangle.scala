package graph.geom

case class Triangle(v1: Vector3D, v2: Vector3D, v3: Vector3D) {

  def area(): Double = 0.5 * ((v3 - v1) X (v3 - v2)).len

  def normalVector(): Vector3D = (v2 - v1) X (v3 - v1)

  def +(v: Vector3D): Triangle = Triangle(v1 + v, v2 + v, v3 + v)

  def *(scale: Double): Triangle = Triangle(v1 * scale, v2 * scale, v3 * scale)

  def *(m: Matrix): Triangle = Triangle(m * v1, m * v2, m * v3)

  def isInPlane(v: Vector3D): Boolean = {
    math.abs((v - v1).dot(normalVector)) <= GraphConst.DELTA
  }
}