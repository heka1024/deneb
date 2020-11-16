package example

import cats.Monad
import cats.implicits._

case class Parser[+A](a: A) extends Monad[Parser] {
  override def flatMap[A, B](fa: Parser[A])(f: A => Parser[B]): Parser[B] = ???

  override def tailRecM[A, B](a: A)(f: A => Parser[Either[A, B]]): Parser[B] = ???

  override def pure[A](x: A): Parser[A] = ???
}
