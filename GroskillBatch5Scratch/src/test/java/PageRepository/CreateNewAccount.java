package PageRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.BaseClass;
import Utilities.SaveCustomerId;


public class CreateNewAccount extends BaseClass  {
	
	 WebDriver driver;
	  String Cust_id = null;
	 
	  
	  public CreateNewAccount(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  @FindBy(xpath="//*[text()='New Account']")
	  WebElement NewAccountLink;
	  

	  @FindBy(xpath="//*[@name='cusid']")
	  WebElement cusidNeWacnt;
	  
	  
	  
	  @FindBy(name = "selaccount")
	  WebElement accountTypeDropdown;
	  
	  
	  
	  @FindBy(xpath="//*[@name='inideposit']")
	  WebElement depo_Amount;
	  
	  
	  @FindBy(xpath="//*[@name='button2']")
	  WebElement newAccnt_SubmitBtn;
	  
	  @FindBy(xpath="//td[text()='Account ID']/following-sibling::td")
	  WebElement accountId;
	  
	  public void newAccount()
	  {
		  NewAccountLink.click();
		  
		  
	  }
	  
	  public void Load_CustidztoNewAccount() 
	  {
		
		  try {Cust_id = SaveCustomerId.fetchCustomerId();
		  		} catch (IOException e)
		  	  {e.printStackTrace();
		  		}
	  
		 
		  System.out.println("cust id loaded in create new account page "+Cust_id);
	  }
	  
	  public void cid()
	  {
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  cusidNeWacnt.sendKeys(Cust_id);
	  }
	  
	  public void selectAccountType(String accountType) {
		    Select select = new Select(accountTypeDropdown);
		    select.selectByVisibleText(accountType);
		}
	 
	  public void depoamount()
	  {
		  depo_Amount.sendKeys("5000");
	  }
	  
	  public void newAccnt_btClick()
	  {
		  newAccnt_SubmitBtn.click();
	  }
	  
	  public String getAccountId()
	  {
		  
		  return accountId.getText();
	  }
	  
}
