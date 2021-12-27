package logui.view

import javafx.scene.control.ScrollPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane

class MainView : BorderPane() {



  init {
    val cont = ScrollPane()
    cont.content = text
    text.isWrapText = true
    this.center = cont
  }

  companion object{

    val text = TextArea()

    fun appendText(string: String) {
      val newText = text.text + string + "\n"
      text.text = newText
    }
  }

}