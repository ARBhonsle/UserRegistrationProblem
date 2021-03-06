package com.userRegistration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User Registration uses regex to check valid inputs
 */
public class UserRegistration {

    // variables
    static Pattern pattern;
    static Matcher matcher;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // display result
    public static boolean displayResult(Pattern pattern, String value) {
        matcher = pattern.matcher(value);
        return matcher.find();
    }

    //UC1,UC2 - valid first/last name
    public static boolean userNameCheck(String name) throws Exception {
        pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
        if (!displayResult(pattern, name)) {
            throw new Exception("Invalid Name");
        }
        return true;
    }

    // UC3, UC9 - valid email for additional check
    public static boolean userEmailCheck(String email) {
        try {
            pattern = Pattern.compile("^[\\w.]+@(?!@)[\\w.]+$");
            if (pattern.matcher(email).find()) {
                pattern = Pattern.compile("^([a-z0-9+_-]+((.){0,1})[a-z0-9+_-]+)@[a-z0-9]+((.){0,1})[a-z]+");
                return displayResult(pattern, email);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // UC4 - check mobile number
    public static boolean mobileNumberCheck(String mobile) {
        pattern = Pattern.compile("91\\s{1}[6-9]{1}[0-9]{9}");
        if (!displayResult(pattern, mobile)) {
            return false;
        }
        return true;
    }

    // UC5, UC6 - check password - length min= 8, Contains 1+ Capital letter
    public static boolean checkPassword(String password) {
        try {
            pattern = Pattern.compile("\\S{8,}");
            if (pattern.matcher(password).find()) {
                pattern = Pattern.compile("(\\S*[A-Z]+\\S*)");
                return displayResult(pattern,password);
            }
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("User Registration");

    }
}
