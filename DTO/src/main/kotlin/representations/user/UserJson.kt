package representations.user

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class UserJson(
  val name: String
)

object UserJsonResolver{
  val json = Json{}
  fun resolveFromString(jsonString: String): UserJson {

    return json.decodeFromString<UserJson>(jsonString)
  }

  fun toJson(user: UserJson) :String {
    val json = Json{}
    return json.encodeToString(user)
  }

}


