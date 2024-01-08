package data.external

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import utils.CommonLogger

class RESTfulManager: RESTfulAPI {

    override val client: HttpClient = HttpClient()


    /**
     * Get an entry of the database sorted by a specific key
     *
     * @param key -> name of the key
     * @param value -> key itself
     * @return Entry of the Database
     */
    override suspend fun getEntryByKey(key: String, value: String, apitype: APIType): String {
        val response = client.get(RESTfulLinks().getEntryByKeyLink(apitype)){
            url {
                parameters.append(key, value)
            }
        }
        return response.bodyAsText() // Cleartext
    }

    /**
     * edit or create an entry in database with the specific keys
     *
     * @param keys -> name of the keys
     * @param values -> keys itself
     */
    override suspend fun editOrCreateEntryWithKeys(keys: List<String>, values: List<String>, apitype: APIType) {
        val response = client.post(RESTfulLinks().editOrCreateEntryWithKeys(apitype)){
            url {
                for (i in 1..keys.size) {
                    parameters.append(keys[i-1], values[i-1])
                }
            }
        }
        val commonLogger = CommonLogger()
        commonLogger.log(response.bodyAsText())
    }

    /**
     * Check whether entry exists or not
     *
     * @param key -> name of the key
     * @param value -> key itself
     * @return Entry of the Database
     */
    override suspend fun doesEntryExist(key: String, value: String, apitype: APIType): Boolean {
        val response = client.get(RESTfulLinks().doesEntryExist(apitype)){
            url {
                parameters.append(key, value)
            }
        }
        return response.bodyAsText().contains("true")
    }
}