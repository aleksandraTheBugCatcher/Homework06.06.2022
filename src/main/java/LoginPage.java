import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By menuToggle = new By.ById("menu-toggle");
    private By loginToggle = new By.ByXPath("//*[@id='sidebar-wrapper']/ul/li[3]/a");
    private By usernameField = new By.ById("txt-username");
    private By passwordField = new By.ById("txt-password");
    private By loginBtn = new By.ById("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void menuToggleClick(){getDriver().findElement(menuToggle).click();}
    public void loginToggleClick(){getDriver().findElement(loginToggle).click();}

    public void enterUsername(String username){
        getDriver().findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        getDriver().findElement(passwordField).sendKeys(password);
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
    }
    public boolean isLoginButtonEnabled(){return getDriver().findElement(loginBtn).isEnabled();}

    public void clickLoginBtn(){
        getDriver().findElement(loginBtn).click();
    }
}

