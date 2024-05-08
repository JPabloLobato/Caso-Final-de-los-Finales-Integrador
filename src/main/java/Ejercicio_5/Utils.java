package Ejercicio_5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Utils {

    public static boolean isInvalidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public static boolean isInvalidAlias(String alias) {
        String aliasRegex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(aliasRegex);
        Matcher matcher = pattern.matcher(alias);
        return !matcher.matches();
    }
}