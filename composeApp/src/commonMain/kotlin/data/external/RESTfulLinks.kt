package data.external

class RESTfulLinks {

    private val url: String = "https://felix.henneri.ch/php/TeamThreads/"
    private val url1: String = url + "getEntryByKey.php"
    private val url2: String = url + "editOrCreateEntryWithKeys.php"
    private val url3: String = url + "doesEntryExist.php"
    private val url4: String = url + "getEntryByKeyCompany.php"
    private val url5: String = url + "editOrCreateEntryWithKeysCompany.php"
    private val url6: String = url + "doesEntryExistCompany.php"

    /**
     * Get link for RESTfulAPI Request
     *
     * @param apiType -> User/Company etc..
     * @return Link
     */
    fun getEntryByKeyLink(apiType: APIType): String {
        return when(apiType){
            APIType.USER -> url1
            APIType.COMPANY -> url4
            else -> {
                "error"
            }
        }
    }

    /**
     * Get link for RESTfulAPI Request
     *
     * @param apiType -> User/Company etc..
     * @return Link
     */
    fun editOrCreateEntryWithKeys(apiType: APIType): String {
        return when(apiType){
            APIType.USER -> url2
            APIType.COMPANY -> url5
            else -> {
                "error"
            }
        }
    }

    /**
     * Get link for RESTfulAPI Request
     *
     * @param apiType -> User/Company etc..
     * @return Link
     */
    fun doesEntryExist(apiType: APIType): String {
        return when(apiType){
            APIType.USER -> url3
            APIType.COMPANY -> url6
            else -> {
                "error"
            }
        }
    }
}