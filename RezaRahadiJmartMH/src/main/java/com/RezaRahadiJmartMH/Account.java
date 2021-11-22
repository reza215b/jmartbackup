package com.RezaRahadiJmartMH;
import com.RezaRahadiJmartMH.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!\\-)[a-zA-Z0-9-]+.(?!.*\\.$)[a-zA-Z0-9.]+$";
    public static final String REGEX_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.*[\\s]).{8,}$";

    public double balance;
    public String name;
    public String email;
    public String password;
    public Store store;

    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    /*
    @Override
    public boolean read (String content) {
        return false;
    }
    
    public String toString(){
        return
        "name: " +this.name+
        "\nemail: " +this.email+
        "\npassword : " +this.password;
    }
    */
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(email);
        Matcher matcher2 = pattern2.matcher(password);
        return matcher.matches() && matcher2.matches();
    }
}
