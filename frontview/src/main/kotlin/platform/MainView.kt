package platform

import javafx.scene.Parent
import javafx.scene.layout.BorderPane

class MainView(
   table: Parent,
    controls: Parent
) : BorderPane() {

  init {
    center = table
    right = controls
  }

}