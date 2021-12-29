package representations.user

import kotlinx.serialization.Serializable


@Serializable
data class UserJson(
  val name: String
)