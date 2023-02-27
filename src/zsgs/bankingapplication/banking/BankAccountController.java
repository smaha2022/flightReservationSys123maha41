package zsgs.bankingapplication.banking;

import java.util.ArrayList;
import java.util.Date;

import zsgs.bankingapplication.dto.Transection;

public class BankAccountController {
	        private BankAccount bankaccount;
			public BankAccountView bankaccountview;
			public BankAccountController(BankAccountView bankaccountview) 
			{
				
				this.bankaccountview=bankaccountview;
			    this.bankaccount=new BankAccount(this);
			}
			
			public void checkBalance(int balance) {
				bankaccount.CheckBalance(balance);	
			}
			public void returncheckBalance(long balance) {
				bankaccountview.viewAcBalance(balance);
			}
			public void returncheckBalance(String error) {
				bankaccountview.viewAcBalance(error);
			}

			public void checkWithDrawFund(int  accountNo,long Amount, Date dateInput) {
				bankaccount.checkWithDrawFund(accountNo,Amount,dateInput);
			}
			public void returncheckWithDrawFund(long balance,long amount) {
				bankaccountview.withdrawBalance(balance, amount);
			}
	        public void returncheckWithDrawFund(String  error) {
	        	bankaccountview.withdrawBalance(error);
			}


			public void checkTrasactionHistory(int accountNo) {
				bankaccount.CheckTransactionHistory(accountNo);
			}
			public void returnTrasactionHistory(ArrayList<Transection> userTansection) {
				bankaccountview.transectionHistory(userTansection);		
			}

			public void checkDeposit(int accountNo,long Amount, Date date ) {
				bankaccount.checkDeposit(accountNo,Amount,date);
				
			}
			public  void returncheckDeposit(long balance, long amount) {

				bankaccountview.depositBalance(balance, amount);
			}

			
			

		

	}