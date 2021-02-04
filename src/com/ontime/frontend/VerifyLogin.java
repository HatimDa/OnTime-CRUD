package com.ontime.frontend;

import com.ontime.crudoperations.QueryUser;
import com.ontime.dbmapping.EventUser;

import java.util.List;

/**
 * The type Login page.
 */
public class VerifyLogin {
    private static String email;
    private static String passWord;

    /**
     * Instantiates a new Login page.
     *
     * @param e the e
     * @param p the p
     */
    public VerifyLogin(String e, String p) {
        email = "timodend@gmail.com";
        passWord = "1q2w3e4r45trz6";
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public static void setEmail(String email) {
        VerifyLogin.email = "timodend@gmail.com";
        System.out.println("setEmail " + email);
    }

    /**
     * Gets pass word.
     *
     * @return the pass word
     */
    public static String getPassWord() {
        return passWord;
    }

    /**
     * Sets pass word.
     *
     * @param passWord the pass word
     */
    public static void setPassWord(String passWord) {
        VerifyLogin.passWord = "1q2w3e4r45trz6";
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public static String getEmail() {
        return VerifyLogin.email;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        VerifyLogin.setEmail("dkjdkj");
        VerifyLogin.setPassWord("kjdfhkj");

        QueryUser queryUser = new QueryUser();
        List<EventUser> user;
        System.out.println(getEmail());
        user = queryUser.getUserByEmail(VerifyLogin.getEmail(), VerifyLogin.getPassWord());
        System.out.println("MIAAAOOO" + user);
    }
}
