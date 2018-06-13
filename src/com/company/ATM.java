package com.company;

import javafx.util.Pair;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int accountNum = 0;
        String pin = null;
        boolean accontExist = false;
        boolean validPin = false;
        Account account = new Account();
        HashMap<Integer, HashMap<String, Double>> accounts = new HashMap<>();
        DecimalFormat df = new DecimalFormat(".##");
        int count=0;
        String process = null;
        double balance = 0;


        accounts = account.getAccountList();

        while (accontExist == false)
        {
            System.out.println("Enter your account number: ");
            accountNum = scanner.nextInt();
            accontExist = account.checkValidAccount(accounts, accountNum);
            if(accontExist==false)
            {
                System.out.println("Your account number is not exist.");
            }
        }

        while (validPin == false)
        {
            System.out.println("Enter your pin: ");
            pin = scanner.next();
            validPin = account.checkValidPin(accounts, accountNum, pin);
            if(validPin == false)
            {
                System.out.println("Your pin is not correct.");
                count ++;
                if(count > 2)
                {
                    System.out.println("You input 3 times wrong pin number. please try later.");
                    System.exit(-1);
                }
            }
        }
        System.out.println("Do you want to Deposit<d>, Withdraw<w> or Check balance<c>? ");
        process = scanner.next();

        while(!process.equals("d")&&!process.equals("w")&&!process.equals("c")) {
            System.out.println("Do you want to Deposit<d>, Withdraw<w> or Check balance<c>? ");
            process = scanner.next();
        }

        if(process.equals("d"))
        {
            System.out.println("How much do you want to deposit?");
            double amount = scanner.nextDouble();
            balance= account.deposit(accounts, accountNum, pin, amount);
            System.out.println("Successfully deposited.");
        }
        else if (process.equals("w"))
        {
            System.out.println("Your current balance is : "+account.displayBalance(accounts, accountNum, pin));
            System.out.println("How much do you want to withdraw?");
            double amount = scanner.nextDouble();
            while(amount > account.displayBalance(accounts, accountNum, pin))
            {
                System.out.println("Your current balance is less than the amount you want to withdraw.");
                System.out.println("How much do you want to withdraw?");
                amount = scanner.nextDouble();
            }

            balance = account.withdraw(accounts, accountNum, pin, amount);
            System.out.println("Please take your widrawal");
        }
        else
        {
            balance = account.displayBalance(accounts, accountNum, pin);
        }
        
        System.out.println("Your current balance is $"+ df.format(balance));

    }
}


