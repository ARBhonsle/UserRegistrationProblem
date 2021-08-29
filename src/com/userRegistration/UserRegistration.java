package com.userRegistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User Registration uses regex to check valid inputs
 */
public class UserRegistration {

    // variables
    static Pattern pattern;
    static Matcher matcher;

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
    public static boolean mobileNumberCheck(String mobile) throws Exception {
        pattern = Pattern.compile("91\\s{1}[6-9]{1}[0-9]{9}");
        if (!displayResult(pattern, mobile)) {
            throw new Exception("Invalid Mobile Number");
        }
        return true;
    }

    // UC5, UC6, UC7, UC8 - check password - length min= 8, Contains 1+ Capital letter,
    // Contains atleast one number,one special Character
    public static boolean checkPassword(String password) throws Exception {
        try {
            pattern = Pattern.compile("\\S{8,}");
            if (pattern.matcher(password).find()) {
                pattern = Pattern.compile("(\\S*[A-Z]+\\S*[0-9]+\\S*[^a-zA-Z0-9\\s]{1}\\S*)");
                if (!displayResult(pattern, password)) {
                    throw new Exception("Invalid Password");
                }else{
                    return true;
                }
            } else {
                throw new Exception("Invalid Password");
            }
        } catch (Exception e) {
            throw new Exception("Invalid Password");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("User Registration");
        System.out.println("Give User First Name (Start with Capital Letter and min 3 characters)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        System.out.println(userNameCheck(userInput));
        System.out.println("Entered Last Name is : ");
        userInput = sc.next();
        System.out.println(userNameCheck(userInput));
        System.out.println("Give valid email ID");
        userInput = sc.next();
        System.out.println(userEmailCheck(userInput));
        System.out.println("Give valid mobile number");
        userInput = sc.next();
        System.out.println(mobileNumberCheck(userInput));
        System.out.println("Give valid password");
        userInput = sc.next();
        System.out.println(checkPassword(userInput));
    }
}
