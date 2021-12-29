package httpserver.routing

import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import services.UserService

object ServerRoutes {

  val routes = routes(
    Routes.ping bind Method.GET to {
      val queryResult = it.query(Routes.pingQuery)

      LoggingService.log("Client sent: $queryResult")

      Response(Status.OK).body("some nice response to GET $queryResult")
    },
    Routes.postUser bind Method.POST to {

      LoggingService.log("Client sent: ${it.bodyString()}")

      UserService.addUser(UserService.resolveJson(it.bodyString()))



      Response(Status.OK)
    }

  )


}