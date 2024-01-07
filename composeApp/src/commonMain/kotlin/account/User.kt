package account

class User: UserInterface {

    data class User(
        val uuid: String,
        val email: String,
        val password: String,
        val name: String,
        val role: String,
        val birthday: String,
        val signup: String,
        val companycode: String
    )

    val keylist = listOf("uuid", "email", "password", "name", "role", "birthday", "signup", "companycode")

    override suspend fun getUser(uuid: String): account.User {
        TODO("Not yet implemented")
    }

    override suspend fun getUUID(name: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getEmail(user: account.User): String {
        TODO("Not yet implemented")
    }

    override suspend fun getPassword(user: account.User): String {
        TODO("Not yet implemented")
    }

    override suspend fun getName(user: account.User): String {
        TODO("Not yet implemented")
    }

    override suspend fun getBirthday(user: account.User): String {
        TODO("Not yet implemented")
    }

    override suspend fun getSignup(user: account.User): String {
        TODO("Not yet implemented")
    }

    override suspend fun getRole(user: account.User): String {
        TODO("Not yet implemented")
    }

    override suspend fun getCompanyCode(user: account.User): String {
        TODO("Not yet implemented")
    }
}