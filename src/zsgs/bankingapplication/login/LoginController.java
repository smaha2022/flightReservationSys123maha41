package zsgs.bankingapplication.login;

import java.util.Random;

import zsgs.bankingapplication.banking.BankAccountView;

public class LoginController {
	private LoginModel loginmodel ;
	private LoginView loginview;
	
	
	
	public LoginController(LoginView loginView) {
		this.loginview=loginView;
		this.loginmodel=new LoginModel(this);
		
	}
	public void signupSuccess(String name,int accno,Long balance) {
		loginview.signupSuccess(name,accno,balance);
	}
	
	public void checkAdminValid(String username, String password) {
		loginmodel.checkAdminValid(username,password);	
	}
	public void adminLoginSuccess(String username) {
		loginview.adminloginSuccess(username);
	}
	public void loginSuccess(String username) {
		loginview.adminloginSuccess(username);
	}
	public void loginFailure(String errormessage) {
		loginview.adminloginFailure(errormessage);
	}
	public void signupfailed(String error) {
		loginview.signupfailed(error);
	}
	

	
	
	public void checkForlogin(int accountNumber , String password) {
		
		loginmodel.checkUserValid(accountNumber, password);
	}
	
	public void createAccount(String name, String email, String password, int age, long aathaarNo, String address,Long balance) {
		Random rm=new Random();
		int accountno= rm.nextInt(999999);
		loginmodel.checkCreateAccount(accountno,name,age,email,password,aathaarNo,address,balance);
		
	}
	

}



