package testsuites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        UserRegistrationTests.class,
        UserLoginTest.class
})
@SelectPackages("testsuites")
public class UserTestSuite {
}
