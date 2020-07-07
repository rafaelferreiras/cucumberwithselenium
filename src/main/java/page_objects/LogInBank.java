
package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static base_test.BaseTest.getDriver;

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

	@FindBy(how = How.CSS, using = ".sufee-alert.alert.with-close.alert-danger.alert-dismissible.fade.show")

	public WebElement error_login;

	@FindBy(how = How.XPATH, using = "//li[contains(.,'Welcome RAFAEL')]")

	public WebElement sucess_login;

}
