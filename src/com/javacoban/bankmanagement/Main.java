package com.javacoban.bankmanagement;


// Những hành động phía user:
//+ inputInfo : scan
//        + display: sout (toString)
//        + Menu : show menu

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        ArrayList<Account> accountList = accountManagement.getList();
        showMenu();
        while (true) {
            int number = scanner.nextInt();
            switch (number) {

                case 1:
                    Account acc1 = inputInfor();
                    accountManagement.addAccount(acc1);
                    break;
                case 2:
                    System.out.println("Enter ID to delete: ");
                    long idDelete = scanner.nextInt();
                    for (Account acc2: accountList){
                        if (acc2.getID()==idDelete){
                            accountManagement.removeAccount(acc2);
                        }
                    }
                    System.out.println("deleted successfully");
                    break;
                case 3:
                    System.out.println("Enter the ID to find");
                    long idSearch = scanner.nextLong();
                    Account acc3 = accountManagement.searchByID(idSearch);
                    display(acc3);
                    break;
                case 4:
                    for (Account acc4: accountList) {
                        display(acc4);
                    }
                    break;
                case 5:
                    System.out.println("Enter ID to add money");
                    long idAddMoney = scanner.nextLong();
                    System.out.println("Enter the amount to load");
                    double moneyAdd = scanner.nextDouble();
                    for (Account acc5 : accountList){
                        if (acc5.getID()==idAddMoney){
                            acc5.addMoney(moneyAdd);
                        }
                    }
                    System.out.println("extra money success");
                    break;
                case 6:
                    System.out.println("Select the account to withdraw money: ");
                    long idWithdrawMoney = scanner.nextLong();
                    System.out.println("Enter the amount to withdraw");
                    double moneyWithdraw = scanner.nextDouble();
                    for (Account acc6 : accountList){
                        if (acc6.getID()==idWithdrawMoney){
                            acc6.withdraw(moneyWithdraw);
                        }
                    }
                    System.out.println("You have withdrawn : "+moneyWithdraw);
                    break;
                case 7:
                    System.out.println("Enter money transfer ID: ");
                    long idTransfer = scanner.nextLong();
                    System.out.println("Enter the receiving ID: ");
                    long idReceiving = scanner.nextLong();
                    System.out.println("Enter the amount to transfer: ");
                    double amountTransfer = scanner.nextDouble();
                    Account accAccommodation = accountManagement.searchByID(idReceiving);
                    for (Account acc7 : accountList){
                        if(acc7.getID()==idTransfer && acc7.getID()!=idReceiving){
                            acc7.transfer(amountTransfer,accAccommodation);
                            System.out.println("money transfer successfully");
                        }
                    }
                    break;
                case 8:
                    showMenu();
                    break;
                case 9:
                    System.out.println("Thanks for using Agribank");
                    System.out.println("---------GOODBYE------------");
                    return;
                default:
                    System.out.println("Outside the function range!!!");
            }

        }
            }

    public static void showMenu() {
        System.out.println("Welcome to the Agribank");
        System.out.println("Please choose an action: ");
        System.out.println("1. Add Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Search Account");
        System.out.println("4. Display all");
        System.out.println("5. Add money for an account");
        System.out.println("6. Withdraw money from an account");
        System.out.println("7. Transfer money");
        System.out.println("8. Show menu");
        System.out.println("9. Exist");
    }

    public static Account inputInfor() {
        System.out.println("Please input infor of an account: ");
        System.out.print(" ID: ");
        long ID = scanner.nextLong();
        scanner.nextLine();
        System.out.print(" accountName: ");
        String accountName = scanner.nextLine();
        double initialMoney = 50000;
        return new Account(ID, accountName, initialMoney);
    }

    public static void display(Account account) {
        System.out.println(account.toString());
    }


}
