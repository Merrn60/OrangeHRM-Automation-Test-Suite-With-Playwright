# OrangeHRM-Automation-Test-Suite-With-Playwright

 
This project is an automation test suite for the OrangeHRM web application, implemented using Playwright with TestNG and the Page Object Model (POM) design pattern. The suite automates the admin workflow, including user login, adding a new user, verifying user creation, searching for the user, and deleting the user.
Table of Contents

Project Overview
Technologies Used
Prerequisites
Setup Instructions
Project Structure
How to Run Tests
Test Scenarios
Troubleshooting
Contributing
License

Project Overview
This automation suite tests the admin functionality of the OrangeHRM demo website (https://opensource-demo.orangehrmlive.com/). The primary test case (AdminTests) validates the following workflow:

Log in to the application.
Navigate to the Admin module.
Add a new user with specific details.
Verify the user was added by checking the record count.
Search for the newly created user.
Delete the user and verify the deletion.

Technologies Used

Playwright: For browser automation.
TestNG: For test execution and reporting.
Java: Programming language used for scripting.
Page Object Model (POM): Design pattern for modular and maintainable test code.
Maven: For dependency management and build automation.

Prerequisites
To run this project locally, ensure you have the following installed:

Java Development Kit (JDK): Version 11 or higher.
Maven: Version 3.6.0 or higher.
Git: For cloning the repository.
IDE: IntelliJ IDEA, Eclipse, or any Java-compatible IDE.
Browser: Playwright supports Chromium, Firefox, and WebKit. No additional browser setup is required as Playwright manages browser binaries.

Setup Instructions
Follow these steps to set up the project locally:

Clone the Repository:
git clone https://github.com/your-username/orangehrm-automation.git
cd orangehrm-automation


Install Dependencies:Ensure you have a pom.xml file with the required dependencies. Run the following command to download dependencies:
mvn clean install


Verify Java and Maven Installation:
java -version
mvn -version


Configure Playwright:Playwright dependencies are included in the pom.xml. No additional setup is required for browser binaries, as Playwright manages them automatically.

Optional: Configure IDE:

Import the project as a Maven project in your IDE.
Ensure the JDK is set to version 11 or higher in your IDE settings.



Project Structure
orangehrm-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/
│   │   │   │   ├── AdminPage.java       # Page Object for Admin module
│   │   │   │   ├── AddUserPage.java    # Page Object for Add User form
│   │   │   │   ├── LoginPage.java      # Page Object for Login page
│   │   │   ├── utils/
│   │   │   │   ├── PlaywrightFactory.java  # Utility for Playwright setup
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/
│   │   │   │   ├── AdminTests.java     # TestNG test class for admin workflow
├── pom.xml                                # Maven configuration file
├── README.md                              # Project documentation

How to Run Tests

Run via Maven:Execute the tests using the following command:
mvn test


Run Specific Test Class:To run the AdminTests class specifically:
mvn test -Dtest=AdminTests


Run via IDE:

Open the AdminTests.java file in your IDE.
Right-click and select "Run AdminTests" (or equivalent, depending on your IDE).


Test Execution Details:

The tests run in non-headless mode by default (browser visible).
To run in headless mode, modify the PlaywrightFactory.java file or AdminTests.java to set setHeadless(true) in the BrowserType.LaunchOptions.


Test Output:

TestNG reports are generated in the test-output directory.
Console logs display the initial and updated record counts during the test.



Test Scenarios
The AdminTests class includes the following test scenario:

testAdminWorkflow:
Logs in with admin credentials (Admin/admin123).
Navigates to the Admin module.
Captures the initial user record count.
Adds a new user with dynamic username and other details.
Verifies the record count increases by 1.
Searches for the newly added user.
Deletes the user and verifies the deletion.
Resets the search and confirms the final record count.


 
