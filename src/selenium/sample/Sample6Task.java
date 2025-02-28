package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
        WebElement txt1 = driver.findElement(By.xpath("//*[@id=\"heading_2\"]"));
        System.out.println(txt1.getText());
//        1-2 ways to find text: "Test Text 1"
        WebElement txt2 = driver.findElement(By.xpath("//*[@id=\"test1\"]/p[1]"));
        System.out.println(txt2.getText());
        //        1-2 ways to find text: "Test Text 2"
        WebElement txt3 = driver.findElement(By.xpath("//*[@id=\"test1\"]/p[2]"));
        System.out.println(txt3.getText());
//        1-2 ways to find text: "Test Text 3"
        WebElement txt4 = driver.findElement(By.xpath("//*[@id=\"test3\"]/p[1]"));
        System.out.println(txt4.getText());
//        1-2 ways to find text: "Test Text 4"
        WebElement txt5 = driver.findElement(By.xpath("//*[@id=\"test3\"]/p[2]"));
        System.out.println(txt5.getText());
//        1-2 ways to find text: "Test Text 5"
        WebElement txt6 = driver.findElement(By.xpath("//*[@id=\"test2\"]/p[1]"));
        System.out.println(txt6.getText());
//        1-2 ways to find text: "This is also a button"
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"buttonId\"]"));
        System.out.println(btn.getText());
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        WebElement txt1 = driver.findElement(By.cssSelector("#heading_2"));
        System.out.println(txt1.getText());
//        1-2 ways to find text: "Test Text 1"
        WebElement txt2 = driver.findElement(By.cssSelector("#test1 > p.test"));
        System.out.println(txt2.getText());
//        1-2 ways to find text: "Test Text 2"
        WebElement txt3 = driver.findElement(By.cssSelector("#test1 > p.twoTest"));
        System.out.println(txt3.getText());
//        1-2 ways to find text: "Test Text 3"
        WebElement txt4 = driver.findElement(By.cssSelector("#test3 > p:nth-child(1)"));
        System.out.println(txt4.getText());
//        1-2 ways to find text: "This is also a button"
        WebElement btn = driver.findElement(By.cssSelector("#buttonId"));
        System.out.println(btn.getText());
    }
}
