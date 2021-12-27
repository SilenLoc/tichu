package logging

import de.jupf.staticlog.Log


object LogCentral {

  private var consumer: (String) -> Unit = {}

  fun log(input: String) {
    consumer(input)
  }

  fun defineLogConsumer(logAction: (String) -> Unit) {
    Log.info("set Log Consumer")
    consumer = logAction
  }


}

