package PageRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class NewCustomerCreation extends BaseClass {
	
	  WebDriver driver;
	  
	  public NewCustomerCreation(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
       
	  @FindBy(xpath="//a[text()='New Customer']")
	  WebElement NewCustLink;
	  
	  @FindBy(xpath="//input[@name='name']")
	  WebElement Cust_name;
	  
	  @FindBy(xpath="//input[@value='m']")
	  WebElement Gender;
			  
	  @FindBy(xpath="//input[@id='dob']")
	  WebElement Dob;//use date picker
	  
	  @FindBy(xpath="//textarea[@name='addr']")
	  WebElement Address;
	  
	  @FindBy(xpath="//input[@name='city']")
	  WebElement City;
	  
	  @FindBy(xpath="//input[@name='state']")
	  WebElement State;
	  
	  @FindBy(xpath="//input[@name='pinno']")
	  WebElement Pin;
	  
	  @FindBy(xpath="//input[@name='telephoneno']")
	  WebElement Mobile;
	  
	  @FindBy(xpath="//input[@name='emailid']")
	  WebElement Email;
	  
	  @FindBy(xpath="//input[@name='password']")
	  WebElement Password;
	  
	  
	  @FindBy(xpath="//input[@name='sub']")
	  WebElement Submit;
	  
	  @FindBy(xpath="//td[text()='Customer ID']/following-sibling::td")
	  WebElement customerId;
	
	  
	  public void  ClickOnNewCustomer( )
	  {
		  NewCustLink.click();
	  }
	  
	  public void  enterUserName(String cname)
	  {
		  Cust_name.sendKeys(cname);
	  }
	  
	  public void  selectGender( )
	  {
		  Gender.click();
	  }
	  
	  public void enterDob(String dob) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "arguments[0].value=arguments[1];",
		        Dob, dob
		    );
		    Actions act = new Actions(driver);
		    act.moveToElement(Dob).click().perform();
		}
	  public void  enterAdress(String address)
	  {
		  Address.sendKeys(address);
	  }
	  public void  enterCity(String city)
	  {
		  City.sendKeys(city);
	  }
	  public void  enterState(String state)
	  {
		  State.sendKeys(state);
	  }
	  public void  enterpin(String pin)
	  {
		  Pin.sendKeys(pin);
	  }
	  public void  enteMobileb(String mobile)
	  {
		  Mobile.sendKeys(mobile);
	  }
	  public void  enterEmail(String email)
	  {
		  Email.sendKeys(email);
	  }
	  public void  enterPassword(String password)
	  {
		  Password.sendKeys(password);
	  }
	  public void  clickOnSubmitButton()
	  {
		  safeClick(Submit);
		 
	  }
	  
	  public String getCustomerId()
	  {
		  
		  return customerId.getText();
	  }
	  
	  
	  
}
