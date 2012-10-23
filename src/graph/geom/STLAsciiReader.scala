package graph.geom

import scala.io.Source
import scala.util.parsing.combinator.lexical.StdLexical
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

class STLAsciiReader extends StandardTokenParsers {

  override val lexical = new ExprLexical

  lexical.delimiters += (".")
  lexical.reserved += ("solid", "endsolid", "facet", "normal", "outer", "loop", "vertex", "normal", "facet", "endloop", "endfacet")

  def stlfile: Parser[Mesh] = "solid" ~> ident ~ faces <~ "endsolid" ^^ { X => new Mesh(Some(X._1), X._2) }

  def faces: Parser[List[Triangle]] = rep(face)

  def face = "facet" ~> "normal" ~> vector ~> loop

  def loop = "outer" ~> "loop" ~> triangle <~ "endloop" ~ "endfacet"

  def triangle: Parser[Triangle] = repN(3, "vertex" ~> vector) ^^ { X => Triangle(X(0), X(1), X(2)) }

  def vector: Parser[Vector3D] = numericLit ~ numericLit ~ numericLit ^^ { case a ~ b ~ c => Vector3D(a.toDouble, b.toDouble, c.toDouble) }

  def parseAll[T](p: Parser[T], in: String) = phrase(p)(new lexical.Scanner(in)) match {
    case Success(x, _) => x
    case Failure(msg, _) => msg
    case Error(msg, _) => msg
  }

}

class ExprLexical extends StdLexical {
  override def token: Parser[Token] = floatingToken | super.token

  def floatingToken: Parser[Token] =
    optSign ~ rep1(digit) ~ optFraction ~ optExponent ^^
      {
        case sign ~ intPart ~ frac ~ exp =>
          val minus = sign.getOrElse("").toString
          val result = minus :: (intPart mkString "") :: frac :: exp :: Nil mkString ""
          NumericLit(
            result)
      }

  def chr(c: Char) = elem("", ch => ch == c)
  def sign: Parser[Char] = chr('+') | chr('-')
  def optSign: Parser[Option[Char]] = opt(sign)

  def fraction = '.' ~ rep(digit) ^^ {
    case dot ~ ff => dot :: (ff mkString "") :: Nil mkString ""
  }
  def optFraction = opt(fraction) ^^ {
    case None => ""
    case Some(fraction) => fraction
  }

  def exponent = (chr('e') | chr('E')) ~ optSign ~ rep1(digit) ^^ {
    case e ~ Some(optSign) ~ exp => e :: optSign :: (exp mkString "") :: Nil mkString ""
    case e ~ None ~ exp => e :: (exp mkString "") :: Nil mkString ""
  }
  def optExponent = opt(exponent) ^^ {
    case None => ""
    case Some(exponent) => exponent
  }
}

object Main extends App {
  val parser = new STLAsciiReader
  val s = Source.fromFile("Idler_Bearing_Plate.stl").mkString

  val m = parser.parseAll(parser.stlfile, s)
  println(m)

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

}