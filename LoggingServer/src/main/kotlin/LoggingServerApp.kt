
import de.jupf.staticlog.Log
import logging.LogCentral
import serverhttp.serverstartup.Server


fun main() {


  LogCentral.defineLogConsumer { log: String, _: String -> Log.info("Log: $log")}


  Server.startup()


}