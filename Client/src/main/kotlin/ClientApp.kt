

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request


fun main() {
  println("Starting Client...")

  val client = ApacheClient()

  val request2 = Request(Method.GET, "http://localhost:9000/some").query("value", "hey")



  println(client(request2))


}