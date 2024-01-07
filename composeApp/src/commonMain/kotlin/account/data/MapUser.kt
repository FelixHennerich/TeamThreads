package account.data

import account.User


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

fun mapUsertoUser(user: HashMap<String, String>): User.User {
    return User.User(
        user["uuid"]!!,
        user["email"]!!,
        user["password"]!!,
        user["name"]!!,
        user["role"]!!,
        user["birthday"]!!,
        user["signup"]!!
    )
}