
package nsolutions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TestSolutionsPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 * 
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 *
 */
public class TestSolutionsPage
{
  private WebDriver driver;
  private SolutionsPage solutPage;

  @BeforeClass
  private void setup() throws Exception
  {
    // chromedriver.exe is located in the directory listed below
    System.setProperty("webdriver.chorme.driver", "/usr/local/bin/chromedriver");

    driver = new ChromeDriver();
    String baseURL = "https://www.nomissolutions.com";

    driver.get(baseURL);
    driver.manage().window().fullscreen();
    // create an instance of Solutions Page class
    solutPage = new SolutionsPage(driver);
  }

  @AfterClass
  private void tearDown()
  {
    driver.quit();
  }

  @Test
  public void VerifySolutionHeaderMessage1()
  {
    LoadPage homePage = new LoadPage(driver);
    homePage.clickOnSolutions();
    assertEquals(solutPage.getTextFromMessageHeader1(), solutPage.HEADER_MESSAGE_1);
  }

  @Test
  public void VerifySolutionHeaderMessage2()
  {
    assertEquals(solutPage.getTextFromMessageHeader2(), solutPage.HEADER_MESSAGE_2);
  }
}
