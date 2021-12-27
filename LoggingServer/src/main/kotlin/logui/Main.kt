package logui

import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import logging.LogCentral
import logui.view.MainView
import serverhttp.serverstartup.Server

class LogApplication : Application() {
  companion object{
    var mainStage: Stage? = null
  }


  override fun start(stage: Stage) {
    mainStage = stage
    val scene = Scene(uiStartUp(), 500.0, 300.0)
    stage.title = "Log"
    stage.scene = scene
    stage.show()

    MainView.appendText("Here logs should apper")

  }

  private fun uiStartUp(): Parent = MainView()

}

fun main()  {
  LogCentral.defineLogConsumer { input -> MainView.appendText(input) }

  Server.startup()

  Application.launch(LogApplication::class.java)
}