
package com.sdet.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        return new Object[][] {
            {"standard_user", "secret_sauce", true},
            {"locked_out_user", "secret_sauce", false},
            {"invalid_user", "wrong_password", false},
            {"", "secret_sauce", false},
            {"standard_user", "", false}
        };
    }
}