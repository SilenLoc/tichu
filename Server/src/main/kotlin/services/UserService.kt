package services


import model.User
import representations.user.UserJson
import representations.user.UserJsonResolver
import representations.user.UsersJson

object UserService {

  private val users = mutableMapOf<String,User>()




  fun addUser(user: User) {
    if(user.id != null) {
      users[user.id] = user
      LoggingService.log("New UserList: $users")
    }
    LoggingService.log("no user added")
  }


  fun findUserById(id: String) = users[id]

  fun getUsers() = users.values


  fun resolveJson(jsonString: String): User {
    val userJson = UserJsonResolver.resolveFromString(jsonString)

    return User(userJson.name, id = (users.size + 1).toString())
  }

  fun usersToJsonUsers() =
    UsersJson(
      users.values.map {
        UserJson(it.name,
          it.id) }.toSet()
    )
}