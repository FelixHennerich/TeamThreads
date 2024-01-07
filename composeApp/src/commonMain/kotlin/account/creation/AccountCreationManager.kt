package account.creation

class AccountCreationManager {

    fun createAccount(email: String, password: String, name: String, birthday: String) {

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