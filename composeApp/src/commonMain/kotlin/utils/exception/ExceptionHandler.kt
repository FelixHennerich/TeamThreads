package utils.exception

class ExceptionHandler {

    /**
     * Get Error name by the given Exception
     *
     * @param nexception -> Exception thrown by given program look NException.kt
     * @return -> Exception name + code
     */
    fun fetchError(nexception: TException): String {
        return nexception.toString()
    }

    /**
     * Get Error code by the given Exception
     *
     * @param nexception -> Exception thrown by given program look NException.kt
     * @return -> Number of Error
     */
    fun fetchErrorCode(nexception: TException): Int {
        var letterarray = mutableListOf<Char>()
        for (i in 0 until nexception.toString().length) {
            letterarray.add(nexception.toString()[i])
        }
        val size = letterarray.size
        return ("" + letterarray[size - 3] + letterarray[size - 2] + letterarray[size - 1]).toInt()
    }

    /**
     * Get the Message of each Error code
     *
     * @param nexception -> Exception thrown by given program look NException.kt
     * @return -> Whole error message
     */
    fun fetchErrorMessage(nexception: TException): String {
        var message: String? = null
        when (nexception) {
            TException.SUCCESS001 -> message = "Your action was successful."
            /**
             * 100
             */
            TException.Emailwrong100 -> message = "You've entered an invalid email."
            TException.PasswordToWeak101 -> message = "Your password must be longer than 8 letters."
            TException.UsernameLength102 -> message = "Your username has an invalid length."
            TException.UsernameExists103 -> message = "Your username is already used."
            TException.EmailExists104 -> message = "Your Email is already used."
            TException.UnallowedCharacters105 -> message = "There is a character that isnt allowed"
            TException.BirthdayWrong106 -> message = "Enter your birthday like that: dd.mm.yyyy"
            TException.WrongPassword107 -> message = "You've entered a wrong password"
            TException.CompanyCodeWrong108 -> message = "You've entered a wrong Company-Code"
            /**
             * 200
             */
            TException.IsAlreadyFollowing200 -> message = "You're already following."
            TException.IsNotFollowing201 -> message = "You're not following."
            /**
             * 300
             */
            /**
             * 400
             */
            TException.HTTPPosting400 -> message = "Error while posting the HTTP request."
            TException.DatabaseCreation401 -> message =
                "Error while creating user account in database"

            else -> {}
        }

        return message ?: "Error while loading message"
    }

}