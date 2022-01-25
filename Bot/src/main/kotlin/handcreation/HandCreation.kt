package handcreation

import model.Card
import model.HandType
import winevaluator.handType


fun Collection<Card>.createPair(): Collection<Card> {

  val result = mutableListOf<Collection<Card>>()
  this.forEach { card1 ->
    this.forEach { card2 ->
      if (card1 != card2) {
        val potPair = listOf(card1, card2)
        if (potPair.handType == HandType.TwoPair) {
          result.add(potPair)
        }
      }
    }
  }

  return try {
    result.random()
  } catch (e: Exception) {
    emptyList()
  }

}
