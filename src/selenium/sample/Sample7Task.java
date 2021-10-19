package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }
//        tick  "Option 2"
        checkBoxes.get(1).click();

        assertTrue(checkBoxes.get(1).isSelected());
        checkBoxes.get(0);
        checkBoxes.get(2);
        assertFalse(checkBoxes.get(0).isSelected());
        assertFalse(checkBoxes.get(2).isSelected());


//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
        checkBoxes.get(2).click();


//        click result
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"result_button_checkbox\"]"));
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        btn.click();
        WebElement t = driver.findElement(By.id("result_checkbox"));
        assertEquals("You selected value(s): Option 2, Option 3", t.getText());
    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
//        check that none of the radio are selected
        for(WebElement radioButton : radioButtons){
            assertFalse(radioButton.isSelected());
        }
//        select  "Option 3"
        radioButtons.get(2).click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertTrue(radioButtons.get(2).isSelected());
        assertFalse(radioButtons.get(0).isSelected());
        assertFalse(radioButtons.get(1).isSelected());
//        select  "Option 1"
        radioButtons.get(0).click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertTrue(radioButtons.get(0).isSelected());
        assertFalse(radioButtons.get(1).isSelected());
        assertFalse(radioButtons.get(2).isSelected());
//        click result
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"result_button_ratio\"]"));
        btn.click();
//        check that 'You selected option: Option 1' text is being displayed
        WebElement txt = driver.findElement(By.xpath("//*[@id=\"result_radio\"]"));
        assertEquals("You selected option: Option 1", txt.getText());
    }

    @Test
    public void selectOption() throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
//        select "Option 3" in Select
        dropdown.selectByVisibleText("Option 3");
//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
//        select "Option 2" in Select
        dropdown.selectByVisibleText("Option 2");
//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
//        click result
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"result_button_select\"]"));
        btn.click();
//        check that 'You selected option: Option 2' text is being displayed
        WebElement txt = driver.findElement(By.id("result_select"));
        assertEquals("You selected option: Option 2", txt.getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
