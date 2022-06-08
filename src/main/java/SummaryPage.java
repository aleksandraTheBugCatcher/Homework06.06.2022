import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SummaryPage extends BasePage{

    private By facility = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[2]/div[1]/label");
    private By applyForHospReadmiss = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[3]/div[1]/label");
    private By healthcareProg = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[4]/div[1]/label");
    private By visitDate = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[5]/div[1]/label");
    private By comment = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[6]/div[1]/label");
    private By homeBtn = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[7]/p/a");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacility() {
        return facility;
    }

    public By getApplyForHospReadmiss() {
        return applyForHospReadmiss;
    }

    public By getHealthcareProg() {
        return healthcareProg;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getComment() {
        return comment;
    }

    public By getHomeBtn() {
        return homeBtn;
    }
    public String summaryElementList(){
        List<WebElement>elementList = getDriver().findElements(By.id("summary"));
        for (int i=0; i<elementList.size(); i++) {
            elementList.get(i).getText();
        }
        return elementList.toString();
    }

}
