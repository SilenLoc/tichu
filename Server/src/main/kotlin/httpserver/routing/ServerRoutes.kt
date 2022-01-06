package httpserver.routing

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import representations.user.UserJsonResolver
import representations.user.UsersJsonResolver
import services.UserService

object ServerRoutes {

  val routes = routes(
    Routes.ping bind Method.GET to {
      val queryResult = it.query(Routes.pingQuery)

      LoggingService.log("Client sent: $queryResult")

      Response(Status.OK).body("some nice response to GET $queryResult")
    },
    Routes.postUser bind Method.POST to {

      log(it)

      UserService.addUser(UserService.resolveJson(it.bodyString()))

      Response(Status.OK)
    },
    Routes.getUsers bind Method.GET to {

      log(it)

      Response(Status.OK).body(UsersJsonResolver.toJson(UserService.usersToJsonUsers()))
    }


  )

  private fun log(it: Request) {
    LoggingService.log("Client sent: ${it.bodyString()}")
  }


}