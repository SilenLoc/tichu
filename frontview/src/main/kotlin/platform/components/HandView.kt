package platform.components

import javafx.scene.layout.Pane


class HandView(val handId:Int): Pane() {

  private val cardContainer = CardContainer()

  init {
    id = "handview"

    //this.border = Border(BorderStroke(Color.AQUA, BorderStrokeStyle.DASHED, CornerRadii(1.0), BorderWidths(1.0,1.0,1.0,1.0)))

    children.add(cardContainer)
  }


  fun addCards(cards: Collection<CardView>){
    cardContainer.children.addAll(cards)
  }

  fun addCard(card:CardView){
    cardContainer.children.add(card)
  }



}