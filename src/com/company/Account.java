package com.company;

public class Account {
    String accountNum;
    String userName;
    double balance;
    String pin;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double withdraw(double amount)
    {
        if (balance>=amount)
        {
            balance = balance -amount;
        }
        else
        {
            System.out.println("Your current balance is less than the amount you wnat to withdraw.");
        }

        return balance;
    }

    public double deposit(double amount)
    {
        return balance = balance+amount;
    }



}
