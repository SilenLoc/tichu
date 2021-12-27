import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request

object LoggingService {

  var source: String = "undefined"

  private const val preFix: String = "From source: "

  private const val preLog: String = " [ "

  private const val suLog: String = " ] "

  fun log(log: String) {
    println("Starting Logging Client")

    val client = ApacheClient()

    val request = Request(Method.GET, "http://localhost:9090/log")
      .query(
        "inlog",
        preFix + source + preLog + log + suLog)

    println(client(request))

  }


}
