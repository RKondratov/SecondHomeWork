package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Кондратов on 17.06.2018.
 */
public class TravelAndBuyPage {

    @FindBy(xpath = "//a[@href='https://online.sberbankins.ru/store/vzr/index.html#/viewCalc']")
    WebElement button;

    public TravelAndBuyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void pushTheButton() {
        button.click();
    }
}
