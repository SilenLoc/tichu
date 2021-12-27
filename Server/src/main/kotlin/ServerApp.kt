

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
  LoggingService.source = "Server"

  LoggingService.log("starting server...")


  val app: HttpHandler = routes(
    "/some" bind Method.GET to {
      val queryResult = it.query("value")

      LoggingService.log("Client sent: $queryResult")

      Response(OK).body("some nice response to GET $queryResult")
    }
  )

  val server = app.asServer(Undertow(9000)).start()

  LoggingService.log("server started at port: ${server.port()}")



}