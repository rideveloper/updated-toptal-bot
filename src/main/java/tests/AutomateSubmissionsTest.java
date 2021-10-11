package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.FileWriterClass;
import webpages.Homepage;

import java.util.concurrent.TimeUnit;

/**
 * @author Ridwan Mustapha
 */
public class AutomateSubmissionsTest {

    WebDriver driver;

    FileWriterClass fileWriterClass = new FileWriterClass();

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void automateGettingQuestions() {
        Homepage homepage = new Homepage(driver);
        automatePage(homepage);
        while (homepage.isQuestionPage()) {
            String title = homepage.getQuestionTitle();
            String question = homepage.getQuestion();
            String example = homepage.getQuestionExample();

            fileWriterClass.WriteFileToPath(title, question, example);

            homepage.clickSkipQuestionBtn();
        }
    }

    private void automatePage(Homepage homepage) {
        //check if is homepage
        Assert.assertTrue(homepage.isHomePage());

        //if true click on start btn
        homepage.clickOnStartChallengeButton();

        //check if modal pops up
        Assert.assertTrue(homepage.modalPopsUp());

        //check if it needs login
        if (homepage.needsLogin()) {
            homepage.clickOnLoginBtn();
            if (homepage.isGithubLoginPage()) {
                homepage.setGithubUsername("rideveloper");
                homepage.setGithubPassword("Safiat295");
                homepage.clickOnGithubLoginBtn();
            }
        }

        homepage.clickOnModalStartChallengeButton();
    }

    @After
    public void close() {
        driver.close();
    }
}
