package com.company;

import javafx.util.Pair;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Account {
    String accountNum;
    double balance;
    String pin;

    HashMap<Integer, HashMap<String, Double>> accounts = new HashMap<>();


    public Account()
    {
        HashMap<String, Double> map1 = new HashMap<>();
        map1.put("aaaa", 12.5);
        HashMap<String, Double> map2 = new HashMap<>();
        map2.put("bbb", 356.25);
        HashMap<String, Double> map3 = new HashMap<>();
        map3.put("ccccc", 1058.56);
        HashMap<String, Double> map4 = new HashMap<>();
        map4.put("dd", 488895.23);
        HashMap<String, Double> map5 = new HashMap<>();
        map5.put("eeeee", 22586.23);
        HashMap<String, Double> map6 = new HashMap<>();
        map6.put("ffffff", 56.23);


        accounts.put(11111, map1);
        accounts.put(22222, map2);
        accounts.put(33333, map3);
        accounts.put(44444, map4);
        accounts.put(55555, map5);
        accounts.put(66666, map6);
    }

    public HashMap<Integer, HashMap<String, Double>> getAccountList()
    {
        return accounts;
    }

    public boolean checkValidAccount(HashMap accounts, int accountNum)
    {
        if (accounts.containsKey(accountNum))
            return true;
        else
            return false;
    }

    public boolean checkValidPin(HashMap accounts, int accountNum, String pin)
    {
        HashMap<String, Double> map = (HashMap<String, Double>) accounts.get(accountNum);

       if(map.containsKey(pin))
           return true;
       else
           return false;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(HashMap accounts,double balance) {
        this.balance = balance;
    }


    public double withdraw(HashMap accounts, int accountNum, String pin, double amount)
    {
        HashMap<String, Double> map = (HashMap<String, Double>) accounts.get(accountNum);
        balance = map.get(pin);
            balance = balance -amount;
            map.replace(pin, balance);
            accounts.replace(accountNum, map);

        return balance;
    }

    public double deposit(HashMap accounts, int accountNum, String pin, double amount)
    {
        HashMap<String, Double> map = (HashMap<String, Double>) accounts.get(accountNum);
        balance = map.get(pin);
        balance = balance+amount;
        map.replace(pin, balance);
        accounts.replace(accountNum, map);

        return balance;
    }


    public double displayBalance(HashMap accounts, int accountNum, String pin)
    {
        HashMap<String, Double> map = (HashMap<String, Double>) accounts.get(accountNum);
        balance = map.get(pin);
        return balance;
    }

}
