# OrangeHRM-Automation-Test-Suite-With-Playwright
 

This repository contains an automated UI test suite for the [OrangeHRM Demo Website](https://opensource-demo.orangehrmlive.com/), implemented using **Playwright**, **Java**, and **TestNG** with the **Page Object Model (POM)** design pattern.

## 📌 Project Overview

This suite automates an admin workflow on OrangeHRM:
- Login as Admin
- Navigate to the Admin module
- Capture number of existing records
- Add a new user with dynamic username
- Verify that the record count increased by 1
- Search for the new user
- Delete the user
- Verify that the record count decreased by 1

---

## 🛠️ Technologies Used

- **Java** (JDK 11+)
- **Playwright for Java** – UI automation framework
- **TestNG** – Test execution and reporting
- **Maven** – Dependency and build management
- **POM (Page Object Model)** – Modular and maintainable design

---

## 🚀 Prerequisites

Make sure you have the following installed on your system:

- ✅ Java JDK 11 or higher  
- ✅ Maven 3.6 or higher  
- ✅ Git  
- ✅ IDE (e.g., IntelliJ IDEA or Eclipse)

> 💡 No need to install browsers. Playwright automatically handles that.

---
### 🔧 Dependencies

- **Java JDK 11** or higher  
- **Maven 3.6+**  
- **Playwright for Java**  
- **TestNG**  
- **IDE**: IntelliJ IDEA or Eclipse (optional)

---

### 🛠 Tools Used

- `Playwright`: For UI automation  
- `TestNG`: Testing framework  
- `Maven`: Build and dependency management  
- `Git`: Version control  
- `IDE`: IntelliJ IDEA or Eclipse

---

---

### 🧪 Automated Test Scenario

The following end-to-end scenario was automated using Playwright + TestNG + POM:

1. **Navigate to** [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/)
2. **Login** using:
   - Username: `Admin`
   - Password: `admin123`
3. Click on the **Admin** tab in the left sidebar
4. **Capture** the number of records before adding a new user
5. Click **"Add"** and fill in:
   - User Role
   - Employee Name
   - Username
   - Status
   - Password and Confirm Password
6. Click **Save**
7. **Verify** that the number of records increased by 1
8. **Search** using the newly created username
9. **Delete** the user
10. **Verify** that the number of records decreased by 1

---

### ✅ Best Practices Applied

- Page Object Model (POM) for clean code and reusability
- Proper use of **explicit waits** for element stability
- **Assertions** for verifying expected outcomes
- Clean, readable, and modular code structure
- Fully integrated with **Maven + TestNG**

---

 


### ▶️ How to Execute

#### 📥 1. Clone the Project

```bash
git clone https://github.com/your-username/orangehrm-automation.git
cd orangehrm-automation
---
 

