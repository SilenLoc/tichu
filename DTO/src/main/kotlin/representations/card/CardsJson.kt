package representations.card

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import representations.user.UserJson

@Serializable
data class CardJson(
  val name: String,
  val id: String? = null
)

@Serializable
data class CardsJson(
  val cards: List<UserJson>
)


object CardsJsonResolver {
  private val json = Json

  fun resolveFromJson(jsonString: String): CardsJson {
    return json.decodeFromString(jsonString)
  }

  fun toJson(user: CardsJson): String{
    return json.encodeToString(user)
  }
}

object CardJsonResolver {
  private val json = Json

  fun resolveFromString(jsonString: String): CardJson{
    return json.decodeFromString(jsonString)
  }

  fun toJson(Card: CardJson): String {
    return json.encodeToString(Card)
  }

}