package tests;

import com.microsoft.playwright.*;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import pages.AddUserPage;
import pages.AdminPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;


public class AdminTests {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private AdminPage adminPage;
    String newUsername = "test.user" + (int)(Math.random() * 10000);


    @BeforeTest
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        adminPage = new AdminPage(page);
        page.navigate("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testAdminWorkflow() {
        loginPage.login("Admin", "admin123");
        adminPage.clickAdminTab();
        page.waitForTimeout(2000);

        String recordText = page.locator("span:has-text('Records Found')").textContent();


        int initialRecords = Integer.parseInt(recordText.replaceAll("[^0-9]", ""));
        System.out.println("Initial record count from UI: " + initialRecords);

/// ////////////////////////////////////////////


        adminPage.clickAddButton();
        AddUserPage addUserPage = new AddUserPage(page);
        addUserPage.fillUserDetails("Admin",  newUsername, "Enabled", newUsername, "Test@1234");
        addUserPage.save();



        /// /////////////////////////////////////////////////////////

        page.waitForTimeout(2000);

        String updatedRecordText = page.locator("span:has-text('Records Found')").textContent();
        int newRecords = Integer.parseInt(updatedRecordText.replaceAll("[^0-9]", ""));

        System.out.println("New record count from UI: " + newRecords);

        assertEquals(newRecords, initialRecords + 1);

        /// /////////////////////////////////////////////////////////////////

        Locator searchInput = page.locator("//label[contains(text(),'Username')]/parent::div/following-sibling::div//input");
        searchInput.fill(newUsername);


        page.locator("//button[normalize-space()='Search']").click();
        page.waitForTimeout(20000);

//  Step 9: Delete the user
        adminPage.deleteUser();
        page.waitForTimeout(20000);
        /// //////////////////////////////////////////////////////////////

        page.locator("//button[normalize-space()='Reset']").click();
        page.waitForTimeout(2000);

// Step 10: Get final record count after deletion
        String recordTextAfterDelete = page.locator("span:has-text('Records Found')").textContent();
        System.out.println("Raw text after deletion: " + recordTextAfterDelete);
        int recordsAfterDelete = Integer.parseInt(recordTextAfterDelete.replaceAll("[^0-9]", ""));
        if (recordTextAfterDelete.isEmpty()) {
            throw new RuntimeException("Record count text is empty after deletion. Check the locator or wait timing.");
        }



    }

    @AfterTest
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
