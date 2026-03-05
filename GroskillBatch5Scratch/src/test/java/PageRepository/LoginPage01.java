package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class LoginPage01 extends BaseClass
{
  WebDriver driver;
  
  public LoginPage01(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }//this is called page factory
  
  @FindBy(xpath="//input[@name='uid']")
  WebElement  uname;
  
  
  @FindBy(xpath="//input[@name='password']")
  WebElement  pwd;
  
  @FindBy(xpath="//input[@type='submit']")
  WebElement  ligin_btn;
  
  public void enterUserName(String username)
  {
	  uname.sendKeys(username);
	  
  }
  
  
  public void enterPassword(String password)
  {
	  pwd.sendKeys(password);
	  
  }
  
  public void clickLogin()
  {
	
	  ligin_btn.click();
  }
                              
  
  
  
  
}
