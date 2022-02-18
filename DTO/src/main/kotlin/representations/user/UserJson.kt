package representations.user

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class UserJson(
    val name: String,
    val id: String? = null
)

@Serializable
data class UsersJson(
    val users: Set<UserJson>
)


object UsersJsonResolver {
    private val json = Json

    fun resolveFromJson(jsonString: String): UsersJson {
      return json.decodeFromString(jsonString)
    }

    fun toJson(user: UsersJson): String{
      return json.encodeToString(user)
    }
}

object UserJsonResolver {
    private val json = Json

    fun resolveFromString(jsonString: String): UserJson {
        return json.decodeFromString(jsonString)
    }

    fun toJson(user: UserJson): String {
        return json.encodeToString(user)
    }

}


