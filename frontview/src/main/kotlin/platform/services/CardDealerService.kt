package platform.services

import platform.ViewAssembler
import platform.components.CardView

object CardDealerService {

  private val hands = ViewAssembler.hands

  fun dealCardIntoHands(id: Int, card: CardView){
      hands[id]?.addCard(card) ?: Unit
  }










}