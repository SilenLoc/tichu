package winevaluator

import model.Card
import model.HandType
import model.HandTypeEvaluator
import model.WinEvaluator
import java.util.ArrayList



val Collection<Card>.handType: HandType
      get() = HandTypeEvaluator().evaluateHand(ArrayList(this))

fun Collection<Card>.isWinnerOver(otherCards: Collection<Card>): Boolean {
  val evaluator = WinEvaluator()
  evaluator.setLastHandCards(ArrayList(otherCards))

  return evaluator.tieWinner(ArrayList(this))
}