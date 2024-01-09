package account

import account.data.mapUserString
import account.data.mapUsertoUser
import data.external.APIType
import data.external.RESTfulManager

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

    override suspend fun getUser(uuid: String): account.User.User {
        val resTfulManager = RESTfulManager()
        val user = resTfulManager.getEntryByKey("uuid", uuid, APIType.USER)
        val usermap = mapUserString(user)
        return mapUsertoUser(usermap)
    }

    override suspend fun getUserByName(name: String): account.User.User {
        val resTfulManager = RESTfulManager()
        val user = resTfulManager.getEntryByKey("name", name, APIType.USER)
        val usermap = mapUserString(user)
        return mapUsertoUser(usermap)
    }

    override suspend fun getEmail(user: account.User.User): String {
        return user.email
    }

    override suspend fun getPassword(user: account.User.User): String {
        return user.password
    }

    override suspend fun getName(user: account.User.User): String {
        return user.name
    }

    override suspend fun getBirthday(user: account.User.User): String {
        return user.birthday
    }

    override suspend fun getSignup(user: account.User.User): String {
        return user.signup
    }

    override suspend fun getRole(user: account.User.User): String {
        return user.role
    }

    override suspend fun getCompanyCode(user: account.User.User): String {
        return user.companycode
    }
}