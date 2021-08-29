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

    public static void displayResult(Pattern pattern, String value){
        matcher = pattern.matcher(value);
        System.out.println(matcher.find() == true ? "Valid" : "Invalid");
    }

    //UC1,UC2 - valid first/last name
    public static void userNameCheck(String name) {
        pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
        displayResult(pattern,name);
    }
    public static void main(String[] args) {
        System.out.println("User Registration");
        System.out.println("Give User First Name (Start with Capital Letter and min 3 characters)");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        System.out.println("Entered First Name is : ");
        userNameCheck(userInput);
        System.out.println("Entered Last Name is : ");
        userInput = sc.next();
        userNameCheck(userInput);
    }
}
