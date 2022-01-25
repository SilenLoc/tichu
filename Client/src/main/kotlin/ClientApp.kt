

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import representations.user.UserJson
import representations.user.UserJsonResolver


fun main() {
 launchClientWithCLI()

}


fun launchClientWithCLI(){
  println("Starting Client...")

  val serverAdress = "http://localhost:9000"

  LoggingService.source = "Test Client"

  LoggingService.log("Test Client Started")

  val client = ApacheClient()

  val request2 = Request(Method.GET, serverAdress + Routes.ping).query(Routes.pingQuery, "hey")

  val userJsonString = UserJsonResolver.toJson(UserJson("test rrr Name"))

  val request3 = Request(Method.POST, serverAdress + Routes.postUser).body(userJsonString)

  val request4 = Request(Method.GET,serverAdress + Routes.getUsers )




  println(client(request2))
  println(client(request3))
  println(client(request4))
}