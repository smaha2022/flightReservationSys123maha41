package zsgs.bankingapplication.dto;

public class User {
	private int accountNo;
	private String name;
	private int age;
	private String emailId;
	private String password;
	private Long athaarNo;
	private String address;
	private Long accountBalance;
	

	
	public User(int accountNo, String name, int age, String emailId, String password, Long athaarNo, String address,Long balance) {
		
		this.accountNo = accountNo;
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.athaarNo = athaarNo;
		this.address = address;
		this.password=password;
		this.accountBalance=balance;
		
	}
	
	public User(int AccountNo,String password)
	{  this.accountNo = AccountNo;
	
		this.password = password;
	}


	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public long getAccountNo(){
		return accountNo;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public Long getAthaarNo() {
		return athaarNo;
	}
	public String getAddress() {
		return address;
	}


}

