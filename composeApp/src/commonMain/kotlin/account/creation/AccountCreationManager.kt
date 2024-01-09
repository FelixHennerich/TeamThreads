package account.creation

import account.User
import account.utils.UUID
import data.external.APIType
import data.external.RESTfulManager
import utils.CryptoManager
import utils.DateUtil
import utils.exception.TException

class AccountCreationManager {

    val resTfulManager = RESTfulManager()

    suspend fun createAccount(email: String, password: String, name: String, birthday: String, companycode: String): TException {
        if(!charChecker(email) || !charChecker(password) || !charChecker(name))
            return TException.UnallowedCharacters105
        if(!checkEmail(email))
            return TException.Emailwrong100
        if(password.length < 8)
            return TException.PasswordToWeak101
        if(name.length < 3 || name.length > 32)
            return TException.UsernameLength102
        if(!birhtdayChecker(birthday))
            return TException.BirthdayWrong106
        if(!isCompanyCodeExist(companycode))
            return TException.CompanyCodeWrong108
        if(!isEmailAvailable(email))
            return TException.EmailExists104
        if(!isNameAvailable(name))
            return TException.UsernameExists103

        //Current date of the signup
        val currentDate = DateUtil().getCurrentDate()
        //UUID of user
        val uuid = UUID().generate128BitUUID()
        //Teamrank
        val role = "Team"
        //Password encryption here TODO ACUTALY ENCRYPTION NOT WORKING
        val encryptedPassword = CryptoManager().encryptString(password, "KStASz3oK2zGLE")



        try{
            //listOf("uuid", "email", "password", "name", "role", "birthday", "signup", "companycode")
            val entrylist = listOf(uuid, email, encryptedPassword, name, role, birthday, currentDate, companycode)

            //actual creation
            RESTfulManager().editOrCreateEntryWithKeys(User().keylist,entrylist, APIType.USER)
            return TException.SUCCESS001
        }catch (e: Exception){
            e.printStackTrace()
        }
        return TException.DatabaseCreation401
    }

    /**
     * Check if the Email is available
     *
     * @param email -> Email
     * @return Boolean true = is usable false = isnt
     */
    suspend fun isEmailAvailable(email: String): Boolean{
        return !resTfulManager.doesEntryExist("email", email, APIType.USER)
    }

    /**
     * Check if the name is available
     *
     * @param name -> Name
     * @return Boolean true = is usable false = isnt
     */
    suspend fun isNameAvailable(name: String): Boolean{
        return !resTfulManager.doesEntryExist("name", name, APIType.USER)
    }

    /**
     * Check if the code is real
     *
     * @param code -> Company join code
     * @return Boolean true = exist false = doesnt
     */
    fun isCompanyCodeExist(code: String): Boolean {

        return true
    }

    /**
     * Check for validity of email (@ and .)
     *
     * @param email -> Email to Check
     * @return -> Contains = true; Not = false
     */
    fun checkEmail(email: String): Boolean{
        val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        if(emailRegex.matches(email)) {
            return true
        }
        return true
    }

    /**
     * Check for validity of email
     *
     * @param birthday -> Birthday to check
     * @return true or false
     */
    fun birhtdayChecker(birthday: String): Boolean{
        val regex = Regex("\\d{2}.\\d{2}.\\d{4}")
        if(regex.matches(birthday)){
            return true
        }
        return false
    }

    /**
     * Check whether a character is allowed in this context or not
     *
     * @param value -> String that has to be checked
     * @return -> true = string is ok, false = string isnt ok
     */
    fun charChecker(value: String): Boolean{
        val acceptedCharset = mutableListOf("a","b","c","d","e","f","g","'",">","@","~",
            "h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","€","ü",
            "y","z","1","2","3","4","5","6","7","8","9","0","!","§","$","%","&","ä","ö",
            "/","(",")","=","?","ß","*","+","`","´","-","_",".",":",",",";","<"," ")
        for(i in value.indices){
            if(!acceptedCharset.contains(value[i].toString().lowercase())){
                println(value[i])
                return false
            }
        }
        return true
    }

}