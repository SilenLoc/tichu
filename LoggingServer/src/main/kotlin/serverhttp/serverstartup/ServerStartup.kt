package serverhttp.serverstartup

import de.jupf.staticlog.Log
import org.http4k.server.Undertow
import org.http4k.server.asServer
import serverhttp.routes.Routes


object Server {

  fun startup() {
    Log.info("Server starting")

    val app = Routes.logRoutes
    app.asServer(Undertow(9090)).start()

  }

}