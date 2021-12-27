package serverhttp.routes

import org.http4k.core.Method
import org.http4k.routing.bind
import org.http4k.routing.routes
import serverhttp.requesthandeling.Actions
import serverhttp.requesthandeling.Responses

object Routes {

  val logRoutes = routes("/log" bind Method.GET to {

    Actions.printLog(it.query("inlog") ?: "wrong input")

    Responses.OK()
  })



}