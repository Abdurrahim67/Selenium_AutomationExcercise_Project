package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.LinkedList;
import java.util.List;

public class HepsiBurada {

    //hepsiburada.com sitesindeki tüm Tabletleri ekrana yazdirma..


    @Test
    public void test() {
        Driver.getDriver().get("https://hepsiburada.com");
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[text()='Elektronik'])[1]"))).perform();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//*[text()='Bilgisayar/Tablet']"))).perform();
        Driver.getDriver().findElement(By.xpath("//*[text()='Tablet']")).click();

        String url = Driver.getDriver().getCurrentUrl();

        List<WebElement> tabletList = new LinkedList<>();

        for (int i = 1; i <= 18; i++) {
            Driver.getDriver().get(url + "?sayfa=" + i);
            tabletList.addAll(Driver.getDriver().findElements(By.xpath("//*[@data-test-id='product-card-name']")));

            int account = 1;

            for (WebElement w : tabletList
            ) {
                try {
                    System.out.println(account + "=" + w.getText());
                } catch (StaleElementReferenceException e) {

                }
                account++;
            }

        }


    }


}

