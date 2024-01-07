package data.external

import io.ktor.client.HttpClient

interface RESTfulAPI {

    val client: HttpClient
    val url: String

    suspend fun getEntryByKey(key: String, value: String): String

    suspend fun editOrCreateEntryWithKeys(keys: List<String>, values: List<String>)

    suspend fun doesEntryExist(key: String, value: String): Boolean
}