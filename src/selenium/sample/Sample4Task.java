package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
        WebElement num = driver.findElement(By.id("number"));
        num.clear();
        num.sendKeys("56");
//        check that button is not clickable "Clear Result"
        WebElement btn = driver.findElement(By.id("clear_result_button_number"));
        assertFalse(btn.isEnabled());

//        check that text is not displayed
        WebElement tf = driver.findElement(By.id("result_number"));
        var i = tf.getText();
        boolean j;
        if(i.equals("")){
             j = true;
        }else {
             j = false;
        }
        assertTrue(j);
//        click on "Result" button
        WebElement resultBtn = driver.findElement(By.id("result_button_number"));
        resultBtn.click();
//        check that text is displayed


//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        if(tf.getText().equals("You entered number: \"56\"")){
            j = true;
        }else {
            j = false;
        }
        assertTrue(j);
//        check that the button "Clear Result" is clickable now
        assertTrue(btn.isEnabled());
//        click on "Clear Result"
        btn.click();
//        check that the text is still (""), but it is not displayed

    }
// still to doooooo!!!!!!!!!!!!!!!!
    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage
    }
}
