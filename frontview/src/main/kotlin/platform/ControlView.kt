package platform

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox

class ControlView : BorderPane() {

  val dealCardToBtn = ButtonTextField("Deal", "Hand ID")

  private val masterControls  = HBox(dealCardToBtn)


  init {
    center = masterControls
  }

}


class ButtonTextField(btnTitle: String, fieldTitle: String) : HBox() {

  val innerlabel = Label(fieldTitle)
  val innerTextField = TextField()
  val innerBtn = Button(btnTitle)

  init {
    children.addAll(innerlabel, innerTextField, innerBtn)
  }

  fun onAction(action: (String) -> Unit) {
    innerBtn.onAction = EventHandler { action(innerTextField.text) }
  }


}