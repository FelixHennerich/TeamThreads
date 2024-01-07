package account

interface UserInterface {

    suspend fun getUser(uuid: String): User
    suspend fun getUUID(name: String): String
    suspend fun getEmail(user: User): String
    suspend fun getPassword(user: User): String
    suspend fun getName(user: User): String
    suspend fun getBirthday(user: User): String
    suspend fun getSignup(user: User): String
    suspend fun getRole(user: User): String
    suspend fun getCompanyCode(user: User): String
}