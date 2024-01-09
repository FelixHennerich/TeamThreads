package utils.exception

enum class TException {

    SUCCESS001,

    /**
     * 100
     */

    Emailwrong100,
    PasswordToWeak101,
    UsernameLength102,
    UsernameExists103,
    EmailExists104,
    UnallowedCharacters105,
    BirthdayWrong106,
    WrongPassword107,
    CompanyCodeWrong108,

    LogoutError120,
    LogoutWorked121,

    /**
     * 200
     */

    IsAlreadyFollowing200,
    IsNotFollowing201,

    /**
     * 300
     */

    /**
     * 400
     */

    HTTPPosting400,
    DatabaseCreation401,

}