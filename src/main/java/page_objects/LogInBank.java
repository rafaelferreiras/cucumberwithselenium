package page_objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static managers.WebDriverManager.getDriver;

public class LogInBank {

	public LogInBank() {

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(how = How.ID, using = "username")

	public WebElement txt_UserName;

	@FindBy(how = How.ID, using = "password")

	public WebElement txt_Password;

	@FindBy(how = How.ID, using = "submit")

	public WebElement btn_Submit;

}
