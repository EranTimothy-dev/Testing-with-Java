# Testing Java Applications with JUnit and Mockito
## Check the pom.xml to see how to configure JaCoCo to check test coverage
### Example exercises are available in separate branches for better clarity on certain topics

This repo contains code examples for various testing methodologies using two of javas
most popular testing libraries, JUnit and Mockito.

This repo covers various testing methodologies that can be useful for Java developers.

To generate JaCoCo report:
after configuration run the following in the terminal to generate the test report in "target/site/index.html"

```bash
mvn clean test
mvn jacoco:report
```
<hr>

#### NOTE: if you encounter an issue when running the program try running it with maven in the terminal teh commands are listed below
# Running Tests with Maven

## 📌 Running a Single Test Class
To execute a specific test class, use:

```bash
mvn test -Dtest=testsuites.UserLoginTest
```  
This runs only the `UserLoginTest` class.

## 📌 Running a Specific Test Method
To run a single test method within a class, use:

```bash
mvn test -Dtest=testsuites.UserLoginTest#shouldLoginSuccessfully
```  
Replace `shouldLoginSuccessfully` with the actual method name.

## 📌 Passing Environment Variables

### **Linux/macOS:**
Using inline environment variables:
```bash
MY_ENV_VAR=value mvn test -Dtest=testsuites.UserLoginTest
```  
Using `MAVEN_OPTS`:
```bash
export MAVEN_OPTS="-DMY_ENV_VAR=value"
mvn test -Dtest=testsuites.UserLoginTest
```  

### **Windows (CMD):**
```cmd
set MY_ENV_VAR=value && mvn test -Dtest=testsuites.UserLoginTest
```  

### **Windows (PowerShell):**
```powershell
$env:MY_ENV_VAR="value"; mvn test -Dtest=testsuites.UserLoginTest
```  

## 📌 Running All Tests in a Package
To run all tests inside a package, use:

```bash
mvn test -Dtest=testsuites.*
```  
This executes all test classes in the `testsuites` package.  
