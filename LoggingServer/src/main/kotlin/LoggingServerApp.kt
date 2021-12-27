
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer
import org.http4k.core.Method.POST

fun main() {
  println("Starting Logging Server...")

  val app = routes(
    "/log/" bind Method.GET to {
      println("Log: ${it.query("inlog")}")

      Response(OK)
    }
    )


  app.asServer(Undertow(9090)).start()



}