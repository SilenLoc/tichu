package platform

import platform.components.CardView
import platform.services.CardDealerService
import kotlin.random.Random

object Controller {

  fun hookButtons() {

    ViewAssembler.controlView.dealCardToBtn.onAction { id -> dealCards(id) }


  }


  private fun dealCards(id: String) {
    val card = CardView()
      card.changeCardTo(Random.nextInt(57))
    CardDealerService.dealCardIntoHands(id.toInt(), card)
  }


}