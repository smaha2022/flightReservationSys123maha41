package zsgs.bankingapplication.login;

import java.util.Scanner;

import zsgs.bankingapplication.banking.BankAccountView;
public class LoginView {
	LoginController logincontroller;
	Scanner sc = new Scanner(System.in);
	BankAccountView Bv = new BankAccountView();

	public LoginView() {
		logincontroller = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView loginview = new LoginView();
		loginview.menu();
	}

	private void menu() {
		boolean setup = true;
		do {
			System.out.println("welcome to Zoho Bank");
			System.out.println("1.CreateAccount\n2.Login\n3.AdminLogin\n4.exit\n");
			System.out.println("Enter your choice ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				signup();
				break;
			case 2:
				login();
				break;
			case 3:
				adminLogin();
				break;
			case 4:
				setup = false;
				break;
			}
		} while (setup);
	}

	private void login() {
		System.out.println("Enter AccountNumber");
		int accountNumber = sc.nextInt();
		System.out.println("Enter Password");
		String password = sc.next();
		logincontroller.checkForlogin(accountNumber, password);

	}

	private void adminLogin() {
		System.out.println("Enter UserName");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		logincontroller.checkAdminValid(username, password);

	}

	public void signup() {
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Email");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		System.out.println("Enter Age");
		int age = sc.nextInt();
		System.out.println("Enter Aathaar No");
		long athaarNo = sc.nextLong();
		System.out.println("Enter Address");
		String address = sc.next();
		Long balance = 0l;

		logincontroller.createAccount(name, username, password, age, athaarNo, address, balance);
	}

	public void adminloginSuccess(String username) {
		System.out.println("\nWelcome " + username);
		System.out.println("\nSucessfully Login!!!");

	}

	public void signupSuccess(String name, int accountNo, Long balance) {
		System.out.println("------------------------------");
		System.out.println("\n       Welcome " + name);
		System.out.println("\nYour AccountNo is:" + accountNo);
		System.out.println("\n(Please remember your Account Number for Login!!)");
		System.out.println("\nAccountBalance   : " + balance);
		System.out.println("\n Account Sucessfully Created!!");
		System.out.println("------------------------------");
		Bv.displayMainMenu();

	}

	public void signupfailed(String error) {
		System.out.println(error);
		signup();
	}

	public void adminloginFailure(String errormessage) {
		System.out.println(errormessage);

	}

	public void loginSuccess(String username) {
		System.out.println("\nWelcome " + username);
		System.out.println("\nSucessfully Login!!!");
		Bv.displayMainMenu();
	}

}



