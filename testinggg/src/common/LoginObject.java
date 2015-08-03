package common;

import org.openqa.selenium.By;



public class LoginObject extends WebApps{
	
	
protected enum credentials{
	HOMEDEPOT("HOMEDEPOT");
	
	String company;
	static String email = ""; //omitted for security
	static String pw = "";
	
	credentials(String company){
		this.company = company;
	}
}

public void login(String company){
	driver.findElement(By.id(loginId.EMAIL.id)).sendKeys(credentials.email);
	driver.findElement(By.id(loginId.PASSWORD.id)).sendKeys(credentials.pw);
	
	
	switch (company){
	
	case "HOMEDEPOT":
	driver.findElement(By.id(loginId.USER.id)).sendKeys(credentials.HOMEDEPOT.company);
	}
	driver.findElement(By.id(loginId.LOGINBUTTON.id)).click();
	
}



	
	
}


