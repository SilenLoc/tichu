package serverhttp.requesthandeling

import logging.LogCentral

object Actions {

    fun printLog(input: String, source: String = "unknown") = LogCentral.log(input, source)


}