package testsuites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        UserRegistrationTests.class,
        UserLoginTest.class
})
//@SelectPackages("com.package.testpackage")
public class UserTestSuite {
}
