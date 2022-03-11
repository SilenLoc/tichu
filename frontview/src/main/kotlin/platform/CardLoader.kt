package platform

import javafx.scene.image.Image
import javafx.scene.image.ImageView

object CardLoader {

  val normalCards = loadNormalCards()

  private fun loadNormalCards(): Map<Int, ImageView> {
    val cards = (1..56).associateWith { index ->
      ImageView(Image("/imgCard/$index.jpg"))
    }

    return cards
  }


}