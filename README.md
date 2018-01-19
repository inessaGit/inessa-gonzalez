# inessa-gonzalez

### Getting Started
- Make sure you have [JDK](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) installed ( version 1.7 or newer)
- Make sure you have [Maven](https://maven.apache.org/) installed
- IDE: Eclipse (or IDE of your choice)
- [TestNG](http://testng.org/doc/)

#### Explanation/Strategy for task of testing RESTful API in Best Buy API playground: 
1. For each endpoint test different request types e.g GET/POST/DELETE 

2. These are good examples of potential basic positive scenarios  http://localhost:3030/queries
for  testing GET for /products endpoint

3. Prioritization of test cases based on complexity
e.g first assert the Response Status Code (to ensure that the request was OK), then the Media Type of the Response, then Response body 

4. GET 
- without parameters
- with parameter limit
- with parameter skip
Assert status code
Assert response content type

5. POST 
- valid parameters in the request body 
- invalid parameters in the request body

6. Currently it is running separate test methods and test classes but with TestNG there is an option for creating test suite
7. Once testng suite.xml created it can be run via Maven in Eclipse, via command line or plugged in into Jenkins


