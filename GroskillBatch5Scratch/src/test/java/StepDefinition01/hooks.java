package StepDefinition01;

import PageRepository.LoginPage01;
import Utilities.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class hooks extends BaseClass {

	//********* log on**********
    @Before("@requiresLogin or @logout")
    public void setup() {

        driver = initializeDriver();   // URL already opened here

        LoginPage01 loginPage = new LoginPage01(driver);

        loginPage.enterUserName("mngr655016");
        loginPage.enterPassword("AsUvyna");
        loginPage.clickLogin();

        System.out.println("Login completed using Hook");
    }

  //********* browser close **********
    
    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}