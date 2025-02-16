package junittesting.testexecutionmethods;

public class SystemInfo {

    public String getOSName() {
        return System.getProperty("os.name");
    }

    public String getJavaVersion() {
        return System.getProperty("java.version");
    }

}
