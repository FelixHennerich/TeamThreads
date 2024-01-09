package account.data

import account.User
import utils.CommonLogger


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