package platform.table

import javafx.scene.Node
import javafx.scene.layout.Pane
import platform.components.HandView

class TableView(
  val hands: Collection<HandView>
) : Pane() {

  init {
    children.addAll(hands)

    arrangeHands()
  }

  private fun arrangeHands() {
    hands.forEachIndexed { index, hand ->
      hand.translateFull(20.0 * index, 20.0 * index)
    }
  }


}

fun Node.translateFull(x: Double, y: Double){
  this.translateX = x
  this.translateY = y
}