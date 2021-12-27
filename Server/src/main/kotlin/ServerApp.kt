

import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
  println("Starting Server...")


  val app: HttpHandler = routes(
    "/some" bind Method.GET to {

      println("getting request...")

      LoggingService.log("got a request from: ${it.source}")


      Response(OK).body("some nice response to POST ${it.query("value")}")
    }
  )

  app.asServer(Undertow(9000)).start()



}