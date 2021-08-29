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
    // UC3- valid email
    public static void userEmailCheck(String email) {
        pattern = Pattern.compile("^[a-z.]+[a-z]+@[a-z.]+[a-z]+");
        displayResult(pattern,email);
    }
    // UC4 - check mobile number
    public static void mobileNumberCheck(String mobile) {
        pattern = Pattern.compile("91\\s{1}[6-9]{1}[0-9]{9}");
        displayResult(pattern,mobile);
    }
    public static void main(String[] args) {
        System.out.println("User Registration");
        System.out.println("Give User First Name (Start with Capital Letter and min 3 characters)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        System.out.println("Entered First Name is : ");
        userNameCheck(userInput);
        userInput = sc.next();
        System.out.println("Entered Last Name is : ");
        userInput = sc.next();
        userNameCheck(userInput);
        System.out.println("Give valid email ID");
        userInput=sc.next();
        userEmailCheck(userInput);
        System.out.println("Give valid mobile number");
        userInput=sc.next();
        mobileNumberCheck(userInput);
    }
}
