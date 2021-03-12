package com.brixham.admity.utilities

class Constants {
    companion object{
        val BASE_URL = "https://api.admity.in/api/"
        val API_KEY = "8f92cb92-c007-448b-b488-brixham-1650492dfd00"
        val A_Token = "dRrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik45"
        val LOGIN_URL = BASE_URL + "Login/Login"
        val CHANGE_PWD_URL = BASE_URL + "Credentials/Passwordchange"
        val STUDENT_PROFILE_DATA_FETCH = BASE_URL + "Profile/ProfileDataFetch"
        val SHARED_PREF_FILE_NAME = "admity_prefs"
        val SHARED_PREFS_USER_ID = "user_id"
        val SHARED_PREFS_USER_NAME = "user_name"
        val SHARED_PREFS_USER_MOBILE = "user_mobile"
        val SHARED_PREFS_USER_EMAIL = "user_email"
        val SHARED_PREFS_USER_PROFILE_IMAGE = "user_profile_image"
        val SHARED_PREFS_STUDENT_ID = "user_student_id"
        val SHARED_PREFS_INS_ID = "user_ins_id"
        val SHARED_PREFS_IS_LOGGED_IN = "is_user_logged_in"
        val SHARED_PREFS_OLD_PWD = "is_user_old_pwd"
        val SHARED_PREFS_NEW_PWD = "is_user_new_pwd"
        val SHARED_PREFS_STUDENT_PROFILE_DATA = "user_profile_data"
    }
}