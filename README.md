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