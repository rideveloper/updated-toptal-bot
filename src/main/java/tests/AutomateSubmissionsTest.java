package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.Homepage;

import java.util.concurrent.TimeUnit;

/**
 * @author Ridwan Mustapha
 */
public class AutomateSubmissionsTest {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void automateSubmission() {
        Homepage homepage = new Homepage(driver);

        //check if is homepage
        Assert.assertTrue(homepage.isHomePage());

        //if true click on start btn
        homepage.clickOnStartChallengeButton();

        //check if modal pops up
        Assert.assertTrue(homepage.modalPopsUp());

        //check if it needs login
        if (homepage.needsLogin())
            homepage.clickOnLoginBtn();
        else homepage.clickOnModalStartChallengeButton();


    }

    @After
    public void close() {
        driver.close();
    }
}
