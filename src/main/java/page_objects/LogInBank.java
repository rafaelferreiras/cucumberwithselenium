package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInBank {

	public LogInBank(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "username")

	private WebElement txt_UserName;

	@FindBy(how = How.ID, using = "password")

	private WebElement txt_Password;

	@FindBy(how = How.ID, using = "submit")

	private WebElement btn_Submit;

	public void loginBank(String user, String pass) {

		txt_UserName.sendKeys(user);
		txt_Password.sendKeys(pass);
		btn_Submit.click();
	}

}
