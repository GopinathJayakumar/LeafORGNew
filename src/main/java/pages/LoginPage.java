package pages;

import wrappers.AppSpecificWrapper;

public class LoginPage extends AppSpecificWrapper{
	
	public LoginPage enterEmailAddress(String email) {
		if(enterValue(getWebElement("xpath", "//input[@placeholder='Email']"), email))
			reportStep("Email address "+email+ "entered Successfully", "PASS");
		else
			reportStep("Email address entry fails", "FAIL");
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		if(enterValue(getWebElement("xpath", "//input[@placeholder='Password']"), password))
			reportStep("Password "+password+ "entered Successfully", "PASS");
		else
			reportStep("Password entry fails", "FAIL");
		return this;
	}
	
	public HomePage clickLogin() {
		if(click(getWebElement("xpath", "//span[text()='Login']"))) {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reportStep("Login button clicked successfully", "PASS");
		}
		else
			reportStep("Login button couldn't click", "FAIL");
		return new HomePage();
	}

}
