package platform.components

import javafx.scene.control.Label
import javafx.scene.layout.Pane
import platform.CardLoader


class CardView: Pane() {

  private val cardHolder = Pane()

  init {


    children.add(Label("some card"))
    children.add(cardHolder)
  }

  fun changeCardTo(cardId: Int){
    cardHolder.children.clear()
    val card = CardLoader.normalCards[cardId]


    val scale  = 2
    card?.fitWidth = 222.0 / scale
    card?.fitHeight = 350.0 / scale

    cardHolder.children.add(card)
  }

}