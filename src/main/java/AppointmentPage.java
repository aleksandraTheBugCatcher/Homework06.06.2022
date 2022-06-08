import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage{
    private By facilitySelect = new By.ById("combo_facility");
    private By applyForHospitalReadmis = new By.ById("chk_hospotal_readmission");
    private By radioBtn = new By.ByXPath("//*[@name='programs'][@value='Medicare']");
    private By visitDateInput = new By.ById("txt_visit_date");
    private By commentInput = new By.ById("txt_comment");
    private By bookAppointmentBtn = new By.ById("btn-book-appointment");


    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacilitySelect() {
        return facilitySelect;
    }

    public By getApplyForHospitalReadmis() {
        return applyForHospitalReadmis;
    }

    public By getRadioBtn() {
        return radioBtn;
    }

    public By getVisitDateInput() {
        return visitDateInput;
    }

    public By getCommentInput() {
        return commentInput;
    }

    public By getBookAppointmentBtn() {
        return bookAppointmentBtn;
    }

    public boolean isFormPresented(){
        List<WebElement> elementList = driver.findElements(By.id("appointment"));
        if (elementList.isEmpty()){
            return false;
        }else return true;

    }
    public void selectFacility(){
        getDriver().findElement(facilitySelect).findElement(By.xpath("//*[@id=\"combo_facility\"]/option[2]")).click();
    }
    public void clickCheckBox(){
        getDriver().findElement(applyForHospitalReadmis).click();
    }

    public void chooseHealthCareProg(){
        getDriver().findElement(radioBtn).findElement(By.xpath("//*[@id=\"radio_program_medicaid\"]"));
    }

    public void inputDate(String date){
        getDriver().findElement(visitDateInput).sendKeys(date);
    }

    public void enterComment(String comment){
        getDriver().findElement(commentInput).sendKeys(comment);
    }

    public boolean isBookAppointmentBtnClickable(){
        return getDriver().findElement(bookAppointmentBtn).isEnabled();
    }
    public void clickBookAppointmentBtn(){
        getDriver().findElement(bookAppointmentBtn).click();
    }

    public void fillAppointmentForm(String date, String comment){
        selectFacility();
        clickCheckBox();
        chooseHealthCareProg();
        inputDate(date);
        enterComment(comment);
    }

}
