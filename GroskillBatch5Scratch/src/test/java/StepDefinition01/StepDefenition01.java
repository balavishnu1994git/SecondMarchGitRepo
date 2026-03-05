package StepDefinition01;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageRepository.CreateNewAccount;
import PageRepository.LogOut;
import PageRepository.NewCustomerCreation;
import Utilities.BaseClass;
import Utilities.SaveAccountId;
import Utilities.SaveCustomerId;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefenition01 extends BaseClass {

    NewCustomerCreation customerPage;
    CreateNewAccount accountPage;
    LogOut logoutPage;

    // Initialize page objects AFTER driver is created in Hook
    @Before("@requiresLogin or @logout")
    public void initPages() {

        customerPage = new NewCustomerCreation(driver);
        accountPage = new CreateNewAccount(driver);
        logoutPage = new LogOut(driver);
    }

    // ================= CUSTOMER CREATION =================

    @Given("User is on the homepage of the application")
    public void user_is_on_homepage() {
        getTitle();
    }

    @Given("User clicks on new customer link")
    public void user_clicks_on_new_customer_link() {
        customerPage.ClickOnNewCustomer();
    }

    @Given("User enter the customer name as {string}")
    public void user_enter_customer_name(String name) {
        customerPage.enterUserName(name);
    }

    @Given("user select gender")
    public void user_select_gender() {
        customerPage.selectGender();
    }

    @Given("User enter date of birth as {string}")
    public void user_enter_dob(String dob) {
        customerPage.enterDob(dob);
    }

    @Given("User enter adress as {string}")
    public void user_enter_address(String address) {
        customerPage.enterAdress(address);
    }

    @Given("User enter city as {string}")
    public void user_enter_city(String city) {
        customerPage.enterCity(city);
    }

    @Given("User enter state as {string}")
    public void user_enter_state(String state) {
        customerPage.enterState(state);
    }

    @Given("User enter pin as {string}")
    public void user_enter_pin(String pin) {
        customerPage.enterpin(pin);
    }

    @Given("User enter mobile as {string}")
    public void user_enter_mobile(String mobile) {
        customerPage.enteMobileb(mobile);
    }

    @Given("User enter email as {string}")
    public void user_enter_email(String email) {
        customerPage.enterEmail(generateRandomEmail());
    }

    @Given("User enter password as {string}")
    public void user_enter_password(String password) {
        customerPage.enterPassword(password);
    }

    @When("click on submit button")
    public void click_on_submit_button() {
        customerPage.clickOnSubmitButton();
    }

    @Then("a new customer Will be created")
    public void verify_customer_created() {
        if (!getCurrentURL().contains("CustomerReg")) {
            throw new AssertionError("Customer not created");
        }
    }

    @Then("user captures the customer id")
    public void capture_customer_id() throws IOException {
        String custId = customerPage.getCustomerId();
        SaveCustomerId.writeCustomerId(custId);
        System.out.println("Customer ID: " + custId);
    }

    // ================= DATATABLE CUSTOMER CREATION =================

    @Given("User enters customer details")
    public void user_enters_customer_details(DataTable dataTable) {

        Map<String, String> data =
                dataTable.asMap(String.class, String.class);

        customerPage.enterUserName(data.get("cust_name"));
        customerPage.selectGender();
        customerPage.enterDob(data.get("dob"));
        customerPage.enterAdress(data.get("address"));
        customerPage.enterCity(data.get("city"));
        customerPage.enterState(data.get("state"));
        customerPage.enterpin(data.get("pin"));
        customerPage.enteMobileb(data.get("mobile"));

        String randomEmail = BaseClass.generateRandomEmail();
        customerPage.enterEmail(randomEmail);

        customerPage.enterPassword(data.get("password"));
    }

    @Then("a new customer will be created Using Data Table")
    public void verify_customer_created_using_data_table() {
        String custId = customerPage.getCustomerId();
        System.out.println("Customer created using DataTable. ID: " + custId);
    }

    // ================= NEW ACCOUNT CREATION =================

    @Given("user open the New Account page")
    public void user_open_the_new_account_page() {
        accountPage.newAccount();
    }

    @Given("user fetch the customer id from excel")
    public void user_fetch_the_customer_id_from_excel() {
        accountPage.Load_CustidztoNewAccount();
    }

    @Given("user Enter customer id")
    public void user_enter_customer_id() {
        accountPage.cid();
    }

    @Given("select  account type")
    public void select_account_type() {
    	   accountPage.selectAccountType("Current");
    }
  

    @Given("user enter deposit amount")
    public void user_enter_deposit_amount() {
        accountPage.depoamount();
    }

    @When("user click on submit button")
    public void user_click_on_submit_button() {
        accountPage.newAccnt_btClick();
    }

    @Then("Amount updated")
    public void amount_updated() {

        if (!getCurrentURL().contains("AccCreateMsg")) {
            throw new AssertionError("Account not created");
        }

        String accId = accountPage.getAccountId();

        try {
            SaveAccountId.writeAccountID(accId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Generated Account ID: " + accId);
    }

    // ================= LOGOUT =================

    @When("User clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        logoutPage.clickLogout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Alert message: " + alert.getText());

        alert.accept();
    }

    @Then("Login page should be displayed")
    public void login_page_should_be_displayed() {

        if (!getCurrentURL().contains("index")) {
            throw new AssertionError("Logout failed -********* Login page not displayed");
        }
    }
}
