# Check the pom.xml to see how to configure JaCoCo to check test coverage

## after configuration run the following in the terminal to generate the test report in "target/site/index.html"

```bash
mvn clean test
mvn jacoco:report
```