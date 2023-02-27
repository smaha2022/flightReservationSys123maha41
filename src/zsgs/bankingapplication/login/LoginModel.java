package zsgs.bankingapplication.login;

import zsgs.bankingapplication.repository.BankingRepository;

public class LoginModel {
	  private LoginController logincontroller;
	  BankingRepository br=BankingRepository.getInstance();
      public LoginModel(LoginController loginController) {
      this.logincontroller = loginController;
 

}
public void checkAdminValid(String username, String password) {
			if(username.equals("MAHA") && password.equals("1998")) {
				logincontroller.adminLoginSuccess(username);
			}else
				logincontroller.loginFailure("Invalid");			
		}
		 		public void checkCreateAccount(int accountno, String name, int age, String email, String password,
				long aadhaarNo, String address,Long Balance){
			if( br.insertUers(accountno, name, age, email, password, aadhaarNo, address, Balance))
			{
				logincontroller.signupSuccess(name,accountno,Balance);
			}
			else
			{
				logincontroller.signupfailed("Failed!!!!");
			}
			        	
		}
		public void checkUserValid(int acNo,String password)
		{
			
       if(br.checklogin(acNo, password)!=null)
       {
    	   logincontroller.loginSuccess(br.checklogin(acNo, password));
       }
       else {
    	   logincontroller.loginFailure("Username or Password Wrong"); 
       }
		}
	}
