package zsgs.bankingapplication.repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zsgs.bankingapplication.dto.Transection;
import zsgs.bankingapplication.dto.User;

public class BankingRepository {
	private  BankingRepository()
	{
	}
	private List<User> UserCredentials = new ArrayList<>();
	private ArrayList<Transection> accountCredentials = new ArrayList<>();

	static BankingRepository bankingDbInstance=null;
	
	public static BankingRepository getInstance()
	{
		try {
			if(bankingDbInstance==null)
			{
					bankingDbInstance = new BankingRepository();		
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 	bankingDbInstance ;
	}
	
	
	
	public String checklogin(int accNo, String password) {
		boolean check = false;
		String name = null;
		for (User uc : UserCredentials) {
			if (uc.getAccountNo() == accNo && uc.getPassword().equals(password)) {
				check = true;
				name = uc.getName();
			}
		}
		if (check) {
			return name;
		} else {
			return name;
		}
	}
	public void viewUsers()
	{
		for (User uc : UserCredentials) {
			System.out.println(uc.getName() + " " + uc.getAge() + " " + uc.getEmailId() + " " + uc.getAccountNo()+ " " + uc.getAccountBalance());
	}
	}
	public boolean insertUers(int accountno, String name, int age, String email, String password, long aadhaarNo,
			String address, Long balance) {

		if (UserCredentials.add(new User(accountno, name, age, email, password, aadhaarNo, address, balance))) {
			
			
			return true;
		} else
			return false;

	}
	
	public long checkBalance(int AccNo)
	{  
		long balance=0;
	    boolean check=false;
		for (User uc : UserCredentials) {
			if(uc.getAccountNo()==AccNo)
			{
				balance=uc.getAccountBalance();
				check =true;	
			}}
			if(check)
			{
				return balance;
			}
			else
			{
				return -1;
			}
		}
	
	
	public long checkDeposit(int acNo,long balance,Date date)
	{
		long updatedBalance=0l;
		
		
		for (User uc : UserCredentials) {
			if(uc.getAccountNo()==acNo)
			{
				
				updatedBalance=uc.getAccountBalance()+balance;
				uc.setAccountBalance(updatedBalance);
				accountCredentials.add(new Transection(acNo,balance,date,"Deposit",updatedBalance));		
			}

		}
		return updatedBalance;	
	}

	public long checkWithdraw(int acNo,long balance,Date date)
	{
		long updatedBalance=0l;
		for (User uc : UserCredentials) {
			if(uc.getAccountNo()==acNo)
			{
				if(balance >uc.getAccountBalance() || uc.getAccountBalance()<0)
				{
				updatedBalance=0l;
				}
				else {
					
				updatedBalance=uc.getAccountBalance()-balance;
				uc.setAccountBalance(updatedBalance);
				accountCredentials.add(new Transection(acNo,balance,date,"Withdraw",updatedBalance));
				}
			}

		}
		return updatedBalance;
		
	}
	
	
	public ArrayList<Transection> viewTransection(int AccountNo)
	{
		ArrayList <Transection> viewTransection =new ArrayList<>();
		for(Transection tc: accountCredentials)
		{
			if(tc.getAccountNumber()==AccountNo)
				viewTransection.add(tc);
		}
		return viewTransection;
	}

		
	}
	
	
	
	
	
	
	
	
	
	
	

