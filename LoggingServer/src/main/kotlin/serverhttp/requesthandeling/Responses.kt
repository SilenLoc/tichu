package serverhttp.requesthandeling

import org.http4k.core.Response
import org.http4k.core.Status

object Responses {

  fun OK() = Response(Status.OK)

}



