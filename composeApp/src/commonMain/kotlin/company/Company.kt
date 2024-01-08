package company

import account.User
import data.external.APIType
import data.external.RESTfulManager

class Company(override val companyid: String) : CompanyInterface {
    override suspend fun createCompany(owner: User.User, companyname: String) {
        val resTfulManager = RESTfulManager()

        val keylist = listOf<String>("name", "id", "ownername", "owneruuid")
        val valuelist = listOf<String>(companyname, companyid, "testid", "testowner")

        resTfulManager.editOrCreateEntryWithKeys(keylist, valuelist, APIType.COMPANY)
    }

    override suspend fun createCompanyCode(companyid: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun joinCompany(user: User.User, companyid: String) {
        TODO("Not yet implemented")
    }

    override suspend fun leaveCompany(user: User.User, companyid: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isCompanyCodeValid(companycode: String, companyid: String): Boolean {
        TODO("Not yet implemented")
    }
}