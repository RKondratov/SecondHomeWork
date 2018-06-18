import pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.PolicyMakerPage;
import pages.TravelAndBuyPage;
import pages.TravelInsurancePage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Кондратов on 18.06.2018.
 */
public class MyRefactoringTest extends BaseTest {
    @Test
    public void testSberbank() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование", driver);
        mainPage.selectInsuranceMenu("Путешествия и покупки");
        mainPage.selectMainMenuAfterBug("Страхование", driver);
        mainPage.selectInsuranceMenu("Путешествия и покупки");
        assertEquals(driver.findElement(By.xpath("//h3[text()='Страхование путешественников']")).getText(), "Страхование путешественников");
        new TravelAndBuyPage(driver).pushTheButton();

        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));

        new TravelInsurancePage(driver).choosePriceAndPushButton("35");

        PolicyMakerPage policy = new PolicyMakerPage(driver);
        policy.setInsuredBirthDate("22.06.1941");
        policy.setInsuredName("Arthas");
        policy.setInsuredSurname("Menethil");
        policy.setSurname("Иванова");
        policy.setName("Ивана");
        policy.setMiddlename("Иванович");
        policy.setBirthDate("09.05.1945");
        policy.setSex("female");
        policy.setPassportSeries("9999");
        policy.setPassportNumber("999999");
        policy.setPassportIssueDate("12.12.2012");
        policy.setIssuePlace("Azeroth WoW");
        policy.pushContinue("Продолжить");

        assertEquals("22.06.1941", policy.getValueOfElement("insuredBirthDate"));
        assertEquals("Arthas", policy.getValueOfElement("insuredName"));
        assertEquals("Menethil", policy.getValueOfElement("insuredSurname"));
        assertEquals("Иванова", policy.getValueOfElement("surname"));
        assertEquals("Ивана", policy.getValueOfElement("name"));
        assertEquals("Иванович", policy.getValueOfElement("middlename"));
        assertEquals("09.05.1945", policy.getValueOfElement("birthDate"));
        assertEquals("9999", policy.getValueOfElement("passportSeries"));
        assertEquals("999999", policy.getValueOfElement("passportNumber"));
        assertEquals("Azeroth WoW", policy.getValueOfElement("issuePlace"));
        assertEquals("12.12.2012", policy.getValueOfElement("issueDate"));
        assertEquals("Заполнены не все обязательные поля", policy.getValueOfElement("cont"));
    }
}