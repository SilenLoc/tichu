

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import representations.user.UserJson
import representations.user.UserJsonResolver


fun main() {
  println("Starting Client...")

  val client = ApacheClient()

  val request2 = Request(Method.GET, "http://localhost:9000${Routes.ping}").query(Routes.pingQuery, "hey")

  val userJsonString = UserJsonResolver.toJson(UserJson("test Name"))

  val request3 = Request(Method.POST, "http://localhost:9000${Routes.postUser}").body(userJsonString)


  println(client(request2))
  println(client(request3))


}