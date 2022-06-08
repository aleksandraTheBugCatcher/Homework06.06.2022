import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void befreClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver, driverWait);

        appointmentPage = new AppointmentPage(driver,driverWait);

        summaryPage = new SummaryPage(driver,driverWait);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

    }

    @AfterClass
    public void driverClose(){driver.close();}

    @Test
    public void loginTest(){
        loginPage.menuToggleClick();
        loginPage.loginToggleClick();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(loginPage.isLoginButtonEnabled());
        loginPage.clickLoginBtn();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test
    public void verifyAppointmentData(){
        appointmentPage.fillAppointmentForm("14/06/2022", "Allergic to penicillin!");
        Assert.assertTrue(appointmentPage.isBookAppointmentBtnClickable());
        appointmentPage.clickBookAppointmentBtn();
        Assert.assertEquals(summaryPage.summaryElementList(),
                "[Hongkong CURA Healthcare Center,Medicaid,14/06/2022,Allergic to penicillin!");
    }

}
