import junittesting.SystemInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemInfoTest {

    private final SystemInfo systemInfo = new SystemInfo();

    @Test
    void getOSNameOnWindows() {
        String osName = systemInfo.getOSName();
        assertTrue(osName.contains("Windows"), "OS name should contain 'Windows'");
    }

    @Test
    void getOSNameOnLinux() {
        String osName = systemInfo.getOSName();
        assertTrue(osName.contains("Linux"), "OS name should contain 'Linux'");
    }

    @Test
    void getJavaVersionOnJava11() {
        String javaVersion = systemInfo.getJavaVersion();
        assertTrue(javaVersion.startsWith("11"), "Java version should start with '11'");
    }

    @Test
    void getOSNameOnMacWithJava17() {
        String osName = systemInfo.getOSName();
        String javaVersion = systemInfo.getJavaVersion();
        assertTrue(osName.contains("Mac"), "OS name should contain 'Mac'");
        assertTrue(javaVersion.startsWith("17"), "Java version should start with '17'");
    }

}
