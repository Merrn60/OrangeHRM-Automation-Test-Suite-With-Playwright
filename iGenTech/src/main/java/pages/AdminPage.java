package pages;

import com.microsoft.playwright.*;

public class AdminPage {
    private Page page;

    public AdminPage(Page page) {
        this.page = page;
    }

    public void clickAdminTab() {
        page.click("a:has-text('Admin')");
    }


    public void clickAddButton() {
        page.click("button:has-text('Add')");
    }

    public void fillUserData(String username, String empName, String email, String role) {
        page.click("div:has(label:text('User Role')) >> .oxd-select-text");
        page.click("div[role='option'] span:text('" + role + "')");

        page.fill("input[placeholder='Type for hints...']", empName);
        page.click("div.oxd-autocomplete-option");

        page.fill("input[autocomplete='off']:below(label:text('Username'))", username);

        page.fill("input[type='password']:below(label:text('Password'))", "Test@1234");
        page.fill("input[type='password']:below(label:text('Confirm Password'))", "Test@1234");
    }

    public void clickSave() {
        page.click("button:has-text('Save')");
    }

    public int getRecordCount() {
        return page.locator(".oxd-table-body .oxd-table-row").count();
    }

    public void searchUser(String username) {
        page.fill("input[placeholder='Username']", username);
        page.click("button:has-text('Search')");
    }

    public void deleteUser() {
        page.click(".oxd-table-body .oxd-table-row .oxd-icon.bi-trash");
        page.click("button:has-text('Yes, Delete')");
    }
}
