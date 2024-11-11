package examples

object vectors {
  trait Vector[N] {
    type Self <: Vector[N]
    def *(x: N): Self
    def +(x: N): Self
    def /(x: N): Self
    def -(x: N): Self
    def apply(i: Int): N
    def length: Int
    override def toString(): String = {
      val sb = new StringBuilder(getClass().getSimpleName())
      sb.append('(')
      var i = 0
      while (i < length) {
        if (i > 0) sb.append(',')
        sb.append(apply(i).toString())
        i += 1
      }
      sb.append(')')
      sb.toString()
    }
  }
  final class Raised[N](n: N) {
    def *(x: Vector[N]): Vector[N] = x * n
    def +(x: Vector[N]): Vector[N] = x + n
    def /(x: Vector[N]): Vector[N] = x / n
    def -(x: Vector[N]): Vector[N] = x - n
  }
  implicit def raiseToVector[N](n: N): Raised[N] = new Raised[N](n)

  case class DoubleVector(v: Array[Double]) extends Vector[Double] {
    type Self = DoubleVector
    def *(x: Double) = rep(k => k * x)
    def +(x: Double) = rep(k => k + x)
    def /(x: Double) = rep(k => k / x)
    def -(x: Double) = rep(k => k - x)
    private def rep(f: Double => Double): Self = {
      val nv = new Array[Double](v.length)
      var i = 0
      while (i < nv.length) {
        nv(i) = f(v(i))
        i += 1
      }
      DoubleVector(nv)
    }
    def apply(i: Int) = v(i)
    def length = v.length
  }
  implicit def doubleArrayToVector(arr: Array[Double]) = new DoubleVector(arr)
  def DoubleVector(d: Double*) = new DoubleVector(d.toArray)

  def main(args: Array[String]) {
    val v = DoubleVector(1, 2, 3, 4, 5, 6)
    println(v)
    println(v * 4.0)
    println(4.0 + v)
    println(v)
  }
}