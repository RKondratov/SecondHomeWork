package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Кондратов on 17.06.2018.
 */
public class TravelInsurancePage {

    @FindBy(xpath = "//section[@class='b-form-section'][2]")
    WebElement element;

    @FindBy(xpath = "//span[@class ='b-continue-btn']")
    WebElement button;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void choosePriceAndPushButton(String value) {
        element.findElement(By.xpath(".//div[contains(text(),'" + value + "')]")).click();
        button.click();
    }
}
