package zsgs.bankingapplication.dto;
import java.util.Date;
public class Transection {
	
	private int accountNumber;
	private Long  balance;
	private String transectionType;
	private Date Date;
	private long accountbalance;
	
	
	public Transection(int accountNumber, Long balance, Date date,String transectionType,long accountbalance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.Date = date;
		this.transectionType=transectionType;
		this.accountbalance=accountbalance;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public Long getBalance() {
		return balance;
	}


	public String getTransectionType() {
		return transectionType;
	}


	public Date getDate() {
		return Date;
	}


	public long getAccountbalance() {
		return accountbalance;
	}
}
