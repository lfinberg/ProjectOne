
package nsolutions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * LoadPageObjectTest //ADDD (description of class)
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
public class TestLoadPage
{
  private WebDriver driver;
  private LoadPage homePage;

  @BeforeClass
  private void setup() throws Exception
  {
    // chromedriver.exe is located in the directory listed below
    System.setProperty("webdriver.chorme.driver", "/usr/local/bin/chromedriver");

    driver = new ChromeDriver();
    String baseURL = "https://www.nomissolutions.com";

    driver.get(baseURL);
    driver.manage().window().fullscreen();
    // create an instance of LoadPage class
    homePage = new LoadPage(driver);
  }

  @AfterClass
  private void tearDown()
  {
    driver.quit();
  }

  @Test
  public void VerifyFirstMenu()
  {
    assertEquals(homePage.MENU_NAME1, homePage.getTextFromFirstMenu());
  }

  @Test
  public void VerifyHeaderMessage()
  {
    assertEquals(homePage.HEADER_MESSAGE_1, homePage.getFirstHeaderMessage());
  }

  @Test
  public void LocateVideoBtn()
  {
    assertEquals(true, homePage.videoButton.isEnabled());
  }

  @Test
  public void LocateFasterImg()
  {
    homePage.clickOnFasterImg();
    assertEquals(homePage.FAST_SUB_MENUS, homePage.numberofParts);
  }

  @Test
  public void VerifyResourcesLoadPage()
  {
    homePage.clickOnResources();
    assertEquals(homePage.EXP_RESORCES_URL, homePage.output_Resources_URL);
  }

  @Test
  public void VerifySolutionsPageLoad()
  {
    homePage.clickOnSolutions();
    assertEquals(homePage.EXP_SOLUTIONS_URL, homePage.output_Solutions_URL);
  }

  @Test(enabled = true)
  public void LocateGetStarted()
  {
    homePage.clickOnGetStarted();
    assertEquals(homePage.GET_STARTED_URL, homePage.output_GetStarted_URL);
  }

}
