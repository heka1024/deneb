package example

import java.io.{BufferedReader, DataOutputStream, IOException, InputStream, InputStreamReader, OutputStream}
import java.net.{ServerSocket, Socket}

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object JavaServer {
  @tailrec
  def loop(listener: ServerSocket): Unit = {
    val socket = listener.accept()
    Try {
      println(s"connected :: ip: ${socket.getInetAddress}, port: ${socket.getPort}")
      val out = socket.getOutputStream
      val dos = new DataOutputStream(out)
      val body = "Hello World".getBytes

      dos.writeBytes("HTTP/1.1 200 OK \r\n")
      dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n")
      dos.writeBytes("Content-Length: " + body.length + "\r\n")
      dos.writeBytes("\r\n")

      dos.write(body, 0, body.length)
      dos.writeBytes("\r\n")
      dos.flush()
    }
    socket.close()
    loop(listener)
  }

  val listener = new ServerSocket(8080)
  loop(listener)

}



