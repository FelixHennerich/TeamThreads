package company

import account.User

interface CompanyInterface {

    val companyid: String

    suspend fun createCompany(owner: User.User, companyname: String)
    suspend fun createCompanyCode(companyid: String): String
    suspend fun joinCompany(user: User.User, companyid: String)
    suspend fun leaveCompany(user: User.User, companyid: String)
    suspend fun isCompanyCodeValid(companycode: String, companyid: String): Boolean

}