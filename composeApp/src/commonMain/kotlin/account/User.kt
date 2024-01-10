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

    /**
     * Get User by the UUID
     *
     * @param uuid -> uuid of User that is targeted
     * @return Actual User
     */
    override suspend fun getUser(uuid: String): account.User.User {
        val resTfulManager = RESTfulManager()
        val user = resTfulManager.getEntryByKey("uuid", uuid, APIType.USER)
        val usermap = mapUserString(user)
        return mapUsertoUser(usermap)
    }

    /**
     * Get User by the Username
     *
     * @param name -> name of User that is targeted
     * @return Actual User
     */
    override suspend fun getUserByName(name: String): account.User.User {
        val resTfulManager = RESTfulManager()
        val user = resTfulManager.getEntryByKey("name", name, APIType.USER)
        val usermap = mapUserString(user)
        return mapUsertoUser(usermap)
    }

    /**
     * Get Email from the User
     *
     * @param user -> User that is targeted
     * @return String of Email
     */
    override suspend fun getEmail(user: account.User.User): String {
        return user.email
    }

    /**
     * Get Password from the User
     *
     * @param user -> User that is targeted
     * @return String of Password
     */
    override suspend fun getPassword(user: account.User.User): String {
        return user.password
    }

    /**
     * Get Name from the User
     *
     * @param user -> User that is targeted
     * @return String of Name
     */
    override suspend fun getName(user: account.User.User): String {
        return user.name
    }

    /**
     * Get Birthday from the User
     *
     * @param user -> User that is targeted
     * @return String of Birthday
     */
    override suspend fun getBirthday(user: account.User.User): String {
        return user.birthday
    }

    /**
     * Get Signup date from the User
     *
     * @param user -> User that is targeted
     * @return String of Signup date
     */
    override suspend fun getSignup(user: account.User.User): String {
        return user.signup
    }

    /**
     * Get Role from the User
     *
     * @param user -> User that is targeted
     * @return String of Role
     */
    override suspend fun getRole(user: account.User.User): String {
        return user.role
    }


    /**
     * Get Companycode from the User
     *
     * @param user -> User that is targeted
     * @return String of Companycode
     */
    override suspend fun getCompanyCode(user: account.User.User): String {
        return user.companycode
    }
}