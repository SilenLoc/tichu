package httpserver.serverstartup

import httpserver.routing.ServerRoutes
import org.http4k.core.HttpHandler
import org.http4k.server.Undertow
import org.http4k.server.asServer

object Server {

  fun start(){
    LoggingService.source = "Server"

    LoggingService.log("starting server...")

    val app: HttpHandler = ServerRoutes.routes

    val server = app.asServer(Undertow(9000)).start()

    LoggingService.log("server started at port: ${server.port()}")
  }



}