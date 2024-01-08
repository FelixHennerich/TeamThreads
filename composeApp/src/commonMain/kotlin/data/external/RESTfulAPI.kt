package data.external

import io.ktor.client.HttpClient

interface RESTfulAPI {

    val client: HttpClient

    suspend fun getEntryByKey(key: String, value: String, apitype: APIType): String

    suspend fun editOrCreateEntryWithKeys(keys: List<String>, values: List<String>, apitype: APIType)

    suspend fun doesEntryExist(key: String, value: String, apitype: APIType): Boolean
}