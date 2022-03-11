package platform

import javafx.scene.Parent
import platform.components.HandView
import platform.table.TableView

object ViewAssembler {

  val hands: Map<Int, HandView> = crateHands()
  val controlView = ControlView()

  fun assemble(): Parent {

    val main = MainView(
      TableView(
        hands.values
      ),
      controlView
    )

    Controller.hookButtons()

    return main
  }


  private fun crateHands(): Map<Int, HandView> {
    return (0..4).map { HandView(it) }.associateBy { it.handId }
  }


}