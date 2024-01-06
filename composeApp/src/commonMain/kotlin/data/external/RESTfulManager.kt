package data.external

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.http.parameters

class RESTfulManager: RESTfulAPI {

    override val client: HttpClient = HttpClient()
    override val url: String = "https://felix.henneri.ch/php/TeamThreads/usermanager.php"

    /**
     * Get an entry of the database sorted by a specific key
     *
     * @param key -> name of the key
     * @param value -> key itself
     * @return Entry of the Database
     */
    override suspend fun getEntryByKey(key: String, value: String): String {
        val response = client.get(url){
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
    override suspend fun editOrCreateEntryWithKeys(keys: List<String>, values: List<String>) {
        client.post(url){
            url {
                for (i in 1..keys.size) {
                    parameters.append(keys[i-1], values[i-1])
                }
            }
        }
    }
}