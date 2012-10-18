package graph.geom

import graph.geom.Vector3D

class Triangle(val v1: Vector3D, val v2: Vector3D, val v3: Vector3D) {

  def area(): Double = 0.5 * ((v3 - v1) X (v3 - v2)).len

  def normalVector(): Vector3D = (v2 - v1) X (v3 - v1)

  def +(v: Vector3D): Triangle = new Triangle(v1 + v, v2 + v, v3 + v)

  def isInPlane(v: Vector3D): Boolean = {
    math.abs((v - v1).dot(normalVector)) <= Vector3D.DELTA
  }

}