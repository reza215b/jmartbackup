package com.RezaRahadiJmartMH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store
{
    // instance variables - replace the example below with your own
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";


    public String address;
    public double balance;
    public String name;
    public String phoneNumber;

    public Store(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return
        "name: " +this.name+
        "\nemail: " +this.address+
        "\npassword : " +this.phoneNumber;
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Pattern pattern2 = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher.find() && matcher2.find();
    }
}
