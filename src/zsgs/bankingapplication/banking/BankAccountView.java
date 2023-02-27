package zsgs.bankingapplication.banking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import zsgs.bankingapplication.dto.Transection;


public class BankAccountView {

    Scanner sc = new Scanner(System.in);
    BankAccountController bac;
    public BankAccountView ()
    {
    	bac=new BankAccountController(this);
    }
    
	public void displayMainMenu() {
        boolean setup = true;
        do {
          
            System.out.println("1. View Account Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.println("Enter a choice");
            int number = sc.nextInt();
            switch (number) {
               
                case 1:
                    viewAccountBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    transactionHistory();
                    break;
                case 5:
                    setup = false;
                    break;
            }
        } while (setup);
    }

    private void transactionHistory() {
    	  System.out.println("Enter AccountNo");
          int accountNo = sc.nextInt();
          bac.checkTrasactionHistory(accountNo);;
	}


    private void viewAccountBalance() {
        System.out.println("Enter AccountNo");
        int accountNo = sc.nextInt();
        bac.checkBalance(accountNo);
        

    }
    private void depositFunds() {
        System.out.println("Enter AccountNo");
        int accountNo = sc.nextInt();
        System.out.println("Enter Amount");
        int amount = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(dateInput);
           bac.checkDeposit(accountNo, amount, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
      
    }

    private void withdrawFunds() {
        System.out.println("Enter AccountNo");
       int  accountNo = sc.nextInt();
        System.out.println("Enter Amount");
        int amount = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(dateInput);
            bac.checkWithDrawFund(accountNo, amount, date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void createdSuccessfully() {
        System.out.println("Welcome to zoho bank! ,Account created Succesfully");
    }
    
    
    public  void viewAcBalance(long balance)
    {
      System.out.println("-------------------");
      System.out.println("Account Balance: "+balance);
      System.out.println("-------------------");
    }
    public  void viewAcBalance(String error)
    {
      System.out.println("-------------------");
      System.out.println(error);
      System.out.println("-------------------");
    }
    public  void depositBalance(long balance,long depositBalance)
    {
      System.out.println("-------------------");
      System.out.println("Deposit Amount: "+depositBalance);
      System.out.println("Account Balance: "+balance);
      System.out.println("-------------------");
    }
    public  void withdrawBalance(long balance ,long withdrawBalance)    {
        System.out.println("-------------------");
        System.out.println("Withdraw Amount: "+withdrawBalance);
        System.out.println("Account Balance: "+balance);
        System.out.println("-------------------");
      }
    public  void withdrawBalance(String error)    {
        System.out.println("-------------------");
        System.out.println(error);
        System.out.println("-------------------");
      }
    
    public  void transectionHistory(ArrayList<Transection> userlist)    {
        System.out.println("--------------------------------------------------");
        System.out.println("Transection History");
for(Transection us:userlist)
	System.out.println(us.getAccountNumber()+" "+us.getBalance()+" "+us.getTransectionType()+" "+us.getDate()+" "+us.getAccountbalance());
	
        System.out.println("---------------------------------------------------");
      }
    
    
    
    
    
    
}