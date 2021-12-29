package services


import model.User
import representations.user.UserJsonResolver

object UserService {

  private val users = mutableListOf<User>()

  fun resolveJson(jsonString: String) = User(UserJsonResolver.resolveFromString(jsonString).name)


  fun addUser(user: User) {
    users.add(user)

    LoggingService.log("New UserList: $user")
  }



}