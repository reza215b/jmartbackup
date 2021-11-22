package com.RezaRahadiJmartMH.controller;

import com.RezaRahadiJmartMH.Account;

import com.RezaRahadiJmartMH.Algorithm;
import com.RezaRahadiJmartMH.Store;
import com.RezaRahadiJmartMH.BasicGetController;
import com.RezaRahadiJmartMH.dbjson.JsonAutowired;
import com.RezaRahadiJmartMH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public abstract class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!\\-)[a-zA-Z0-9-]+.(?!.*\\.$)[a-zA-Z0-9.]+$";
    public static final String REGEX_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.*[\\s]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "C:\\Users\\Asus\\Desktop\\Projek OOP\\jmart\\src\\RezaRahadiJmartMH\\src\\main\\java\\com\\RezaRahadiJmartMH\\account.json")
    public JsonTable<Account> accountTable;

    @Override
    public JsonTable<Account> getJsonTable() {

        return accountTable;
    }

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return Algorithm.<Account>find(accountTable, obj -> obj.email.equals(email) && obj.password.equals(password));
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if(name.isBlank()) return null;
        Matcher matcher1 = REGEX_PATTERN_EMAIL.matcher(email);
        if(!matcher1.find()) return null;
        Matcher matcher2 = REGEX_PATTERN_PASSWORD.matcher(password);
        if(!matcher2.find()) return null;
        if(Algorithm.<Account>find(accountTable, obj -> obj.email.equals(email)) != null) return null;
        Account a = new Account(name, email, password, 0);
        accountTable.add(a);
        return a;
    }

    @PostMapping("/{id}/registerStore")
    Store registerStore
            (
                    @PathVariable int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        Account acc = Algorithm.<Account>find(accountTable, obj -> obj.id == id);
        if(acc == null || acc.store != null) return null;
        acc.store = new Store(name, address, phoneNumber);
        return acc.store;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account acc = Algorithm.<Account>find(accountTable, obj -> obj.id == id);
        if(acc == null) return false;
        acc.balance += balance;
        return true;
    }

}
