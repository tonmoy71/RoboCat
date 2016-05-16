package co.gobd.gofetch.utility;

import android.util.Patterns;

/**
 * Created by tonmoy on 16-May-16.
 */
public class Validator {
    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
