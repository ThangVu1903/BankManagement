package com.javacoban.bankmanagement;


// Những hành động phía user:
//+ inputInfo : scan
//        + display: sout (toString)
//        + Menu : show menu

import java.util.*;

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
                    Account acc1 = inputInfo();
                    accountManagement.addAccount(acc1);
                    break;
                case 2:
                    int count=0;
                    System.out.println("Enter ID to delete: ");
                    long idDelete = scanner.nextInt();
                    Account acc2 = accountManagement.searchByID(idDelete);
                    if (acc2 != null) {
                        accountManagement.removeAccount(acc2);
                        System.out.println("Delete successful accounts!");
                    }
                    else {
                            System.out.println("No account found!!");
                    }

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
                    Account acc5 = accountManagement.searchByID(idAddMoney);
                    if (acc5 != null){
                        acc5.addMoney(moneyAdd);
                        System.out.println("extra money success");
                    }
                    else {
                        System.out.println("No account found!!");
                    }
                    break;
                case 6:
                    System.out.println("Select the account to withdraw money: ");
                    long idWithdrawMoney = scanner.nextLong();
                    System.out.println("Enter the amount to withdraw");
                    double moneyWithdraw = scanner.nextDouble();
                    Account acc6 = accountManagement.searchByID(idWithdrawMoney);
                    if (acc6 != null){
                        acc6.withdraw(moneyWithdraw);
                        System.out.println("withdrew money successfully");
                    }
                    else {
                        System.out.println("No account found!!");
                    }
                    break;
                case 7:
                    System.out.println("Enter money transfer ID: ");
                    long idTransfer = scanner.nextLong();
                    System.out.println("Enter the receiving ID: ");
                    long idReceiving = scanner.nextLong();
                    System.out.println("Enter the amount to transfer: ");
                    double amountTransfer = scanner.nextDouble();
                    Account accReceiver = accountManagement.searchByID(idReceiving);
                    if (accReceiver==null){
                        System.out.println("Account does not exist, please operate again!");
                        break;
                    }
                    Account accTransfer = accountManagement.searchByID(idTransfer);
                    if (accTransfer!=null){
                        accTransfer.transfer(amountTransfer,accReceiver);
                        System.out.println("money transfer successfully!");
                    }
                    else {
                        System.out.println("Account does not exist, please operate again!");
                    }
                    break;
                case 8:
                    Collections.sort(accountList, new Account.arrangeMoney());
                    System.out.println("Account after arranging: ");
                    for (Account acc8: accountList) {
                        display(acc8);
                    }
                    break;
                case 9:
                    showMenu();
                    break;
                case 10:
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
        System.out.println("8. Arrange account according to graduation money");
        System.out.println("9. Show menu");
        System.out.println("10. Exist");
    }

    public static Account inputInfo() {
        System.out.println("Please input info of an account: ");
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





