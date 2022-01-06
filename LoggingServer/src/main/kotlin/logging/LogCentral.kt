package logging

import de.jupf.staticlog.Log


object LogCentral {

    private var consumer: (String, String) -> Unit = { _, _ -> Unit }

    fun log(input: String, source: String) {
        consumer(input, source)
    }

    fun defineLogConsumer(logAction: (String, String) -> Unit) {
        Log.info("set Log Consumer")
        consumer = logAction
    }


}

