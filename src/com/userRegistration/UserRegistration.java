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
    public static void displayResult(Pattern pattern, String value){
        matcher = pattern.matcher(value);
        System.out.println(matcher.find() == true ? "Valid" : "Invalid");
    }

    //UC1,UC2 - valid first/last name
    public static void userNameCheck(String name) {
        pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
        displayResult(pattern,name);
    }
    // UC3, UC9 - valid email for additional check
    public static void userEmailCheck(String email) {
        try {
            pattern = Pattern.compile("^[\\w.]+@(?!@)[\\w.]+$");
            if (pattern.matcher(email).find()) {
                pattern = Pattern.compile("^([a-z0-9+_-]+((.){0,1})[a-z0-9+_-]+)@[a-z0-9]+((.){0,1})[a-z]+");
                displayResult(pattern, email);
            }else{
                System.out.println("Invalid");
            }
        }
        catch(Exception e) {
            System.out.println("Invalid");
        }
    }
    // UC4 - check mobile number
    public static void mobileNumberCheck(String mobile) {
        pattern = Pattern.compile("91\\s{1}[6-9]{1}[0-9]{9}");
        displayResult(pattern,mobile);
    }

    // UC5, UC6, UC7, UC8 - check password - length min= 8, Contains 1+ Capital letter,
    // Contains atleast one number,one special Character
    public static void checkPassword(String password){
        try {
            pattern = Pattern.compile("\\S{8,}");
            if (pattern.matcher(password).find()) {
                pattern = Pattern.compile("(\\S*[A-Z]+\\S*[0-9]+\\S*[^a-zA-Z0-9\\s]{1}\\S*)");
                displayResult(pattern, password);
            }else{
                System.out.println("Invalid");
            }
        }
        catch(Exception e) {
            System.out.println("Invalid");
        }
    }

    public static void main(String[] args) {
        System.out.println("User Registration");
        System.out.println("Give User First Name (Start with Capital Letter and min 3 characters)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        userNameCheck(userInput);
        System.out.println("Entered Last Name is : ");
        userInput = sc.next();
        userNameCheck(userInput);
        System.out.println("Give valid email ID");
        userInput=sc.next();
        userEmailCheck(userInput);
        System.out.println("Give valid mobile number");
        userInput=sc.next();
        mobileNumberCheck(userInput);
        System.out.println("Give valid password");
        userInput=sc.next();
        checkPassword(userInput);
    }
}
