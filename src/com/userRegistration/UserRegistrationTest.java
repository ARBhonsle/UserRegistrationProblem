package com.userRegistration;
import org.junit.Assert;
import org.junit.Test;

/**
 *  UserRegistrationTest tests regex check using JUnit testing
 */

public class UserRegistrationTest {
    UserRegistration user = new UserRegistration();
    // method to check mood
    public static boolean isHappy(String mood){
        if(mood.equals("Happy")){
            return true;
        }
        return false;
    }
    @Test
    public void TestMood(){
        Assert.assertEquals(isHappy("Happy"),true);
        Assert.assertSame(isHappy("Sad"),false);
        Assert.assertEquals(isHappy(""),false);
    }
    @Test
    public void RegexJUnitTesting(){
        Assert.assertEquals(user.userNameCheck("Adi"),true);
        Assert.assertEquals(user.userNameCheck("dcm"),false);
        Assert.assertEquals(user.userEmailCheck("mcoslc@gmail.com"),true);
        Assert.assertEquals(user.userEmailCheck("mcoslc@@gmail.com"),false);
        Assert.assertEquals(user.mobileNumberCheck("91 9031083290"),true);
        Assert.assertEquals(user.mobileNumberCheck("9132432392340192"),false);
        Assert.assertEquals(user.checkPassword("WE14315xlwq$"),true);
        Assert.assertEquals(user.checkPassword("mweo2320KM"),false);
    }
    @Test
    public void RegexTest(){
        String[] list = new String[]{"Adi", "adi", "A", "aDD"};
        boolean[] listAns = new boolean[]{true, false, false, false};
        String[] email = new String[]{"adi.aaa@bl.co.in", "abc.xyz@bl.co", "adi@bl.co.in", "adi@bl.co", "adi.aaa.co.in", "adi.aaa@blco.in", "adi.aaa@bl.co.in","abc.xyz@bl.co","adi@bl.co.in","adi@bl.co","adi.aaa.co.in","adi.aaa@blco.in","asd.@go.co","asd@as@.qwdo","asd@as@.qwd@o","abc@1.com"};
        boolean[] emailAns = new boolean[]{true, true, true, true, false, true, true,true,true,true,false,true,false,false,false,true};
        String[] mobileNumber = new String[]{"91 ", "19 ", "91  ", "91 9888888888", "91 02900", "91 6821993018"};
        boolean[] mobileNumberAns = new boolean[]{false, false, false, true, false, true};
        String[] password = new String[]{"wfcwa","23edws2xdz","wkja ccw","jkdnvfneavkjea","xjoiqidnw","WE14315xlwq#","qwxodw1","ewqeqQewewe1@","aQq"};
        boolean[] passwordAns = new boolean[]{false,false,false,false,false,true,false,true,false};
        // name test
        boolean[] ans = new boolean[list.length];
        for(int i=0;i<list.length;i++){
            ans[i] = user.userNameCheck(list[i]);
        }
        // email test
        Assert.assertArrayEquals(listAns,ans);
        ans = new boolean[email.length];
        for(int i=0;i<email.length;i++){
            ans[i] = user.userEmailCheck(email[i]);
        }
        // mobile number test
        Assert.assertArrayEquals(emailAns,ans);
        ans = new boolean[mobileNumber.length];
        for(int i=0;i<mobileNumber.length;i++){
            ans[i] = user.mobileNumberCheck(mobileNumber[i]);
        }
        Assert.assertArrayEquals(mobileNumberAns,ans);
        // Password test
        ans = new boolean[password.length];
        for(int i=0;i<password.length;i++){
            ans[i] = user.checkPassword(password[i]);
        }
        Assert.assertArrayEquals(passwordAns,ans);

    }
}
