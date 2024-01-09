package account.data

import account.User
import utils.CommonLogger


/**
 * Mapping the user string that is provided by the RESTfulAPI to a Map
 *
 * @param user -> string from database
 * @return Map of user data
 */
fun mapUserString(user: String): Map<String, String>{
    val trimmedString = user.trim('#')

    val keyValuePairs = trimmedString.split("#").map { it.trim() }

    val dataMap = mutableMapOf<String, String>()

    for (pair in keyValuePairs) {
        val (key, value) = pair.split(":", limit = 2).map { it.trim() }

        dataMap[key] = value
    }

    return dataMap
}

/**
 * Map userstring from the function before to the actual User
 *
 * @param user -> Map from function before
 * @return User data class with data
 */
fun mapUsertoUser(user: Map<String, String>): User.User {
    return User.User(
        user["Uuid"]!!,
        user["Email"]!!,
        user["Password"]!!,
        user["Name"]!!,
        user["Role"]!!,
        user["Birthday"]!!,
        user["Signup"]!!,
        user["Companycode"]!!
    )
}