import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request

object LoggingService{

  fun log(log: String) {
    println("Starting Logging Client...")

    val client = ApacheClient()

    val request = Request(Method.GET, "http://localhost:9090/log").query("inlog", log)

    println(client(request))

  }


}
