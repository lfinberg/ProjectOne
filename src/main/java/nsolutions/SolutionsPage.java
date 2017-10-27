
package nsolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * LoadPage //ADDD (description of class)
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
public class SolutionsPage
{
  // define header message for Price Optim. that you want to verify
  final String HEADER_MESSAGE_1 = "Price Optimization";

  // define header message for Our Solutions
  final String HEADER_MESSAGE_2 = "OUR SOLUTIONS";

  // locate and verify message for Price Optimization
  @FindBy(css = "#hs_cos_wrapper_module_142781716245219278>h1")
  private WebElement priceOptimization;

  // locate and verify message for Our Solutions
  @FindBy(css = "#hs_cos_wrapper_module_144015570254430980>h2")
  private WebElement ourSolutions;

  private WebDriver driver;
  private WebDriverWait wait;

  public SolutionsPage(WebDriver driver)
  {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public String getTextFromMessageHeader1()
  {
    return priceOptimization.getText();
  }

  public String getTextFromMessageHeader2()
  {
    return ourSolutions.getText();
  }

}
