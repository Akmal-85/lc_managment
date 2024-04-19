package com.company.lc_managment.utils;


public interface AppConstants {
    String BEARER_TYPE = "Bearer";
    String AUTH_HEADER = "Authorization";
    String REFRESH_AUTH_HEADER = "RefreshToken";
    String PASSWORD_REGEXP = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#_$%^&+=])(?=\\S+$).{8,}$";
    String[] OPEN_PAGES = {

    };

    String AUTH_CONTROLLER_BASE_PATH = "/api/auth";
    String AUTH_CONTROLLER_LOGIN_PATH = "/login";
    String AUTH_CONTROLLER_REFRESH_TOKEN_PATH = "/refresh-token";
    String AUTH_CONTROLLER_REGISTER_PATH = "/register";
    String VERSION ="/v1";
    String BASE_PATH = "/api"+VERSION;


}
