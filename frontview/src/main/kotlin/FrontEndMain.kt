import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import platform.ViewAssembler

class FrontViewApplication : Application() {
  companion object{
    var mainStage: Stage? = null
  }


  override fun start(stage: Stage) {
    mainStage = stage
    val scene = Scene(uiStartUp(), 2200.0, 1000.0)
    scene.stylesheets.add("/main.css")
    stage.title = "Tichu"
    stage.scene = scene
    stage.show()

  }

  private fun uiStartUp(): Parent = ViewAssembler.assemble()

}

fun main()  {
  launchFrontView()
}

fun launchFrontView(){
  Application.launch(FrontViewApplication::class.java)
}