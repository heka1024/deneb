package example

import cats._, cats.data._, cats.implicits._

case class Token(start: Int, mid: Int, end: Int) {
    def toChar: Char = {
      this.start * 21 * 28 + this.mid * 28 + this.end + 44032
    }.toChar
}

object Token {
  def apply(c: Char): Token = {
    new Token(
      (c.toInt - 44032) / (21 * 28),
      { (c.toInt - 44032) % (21 * 28) } / 28,
      { (c.toInt - 44032) % (21 * 28) } % 28
    )
  }
}

object Parsers {
  val firsts = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ"
  val seconds = "ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ"
  val thirds = "ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ"

  "가나다라마바사아자차"
    .map { _.toLong - 44032 }
    .map { _ / (21 * 28) }

  def char2Token
}
