package account

interface UserInterface {

    suspend fun getUser(uuid: String): User.User
    suspend fun getUserByName(name: String): User.User
    suspend fun getEmail(user: User.User): String
    suspend fun getPassword(user: User.User): String
    suspend fun getName(user: User.User): String
    suspend fun getBirthday(user: User.User): String
    suspend fun getSignup(user: User.User): String
    suspend fun getRole(user: User.User): String
    suspend fun getCompanyCode(user: User.User): String
}