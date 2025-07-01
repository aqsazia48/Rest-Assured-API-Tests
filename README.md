# API Testing with RestAssured

This repository contains sample API tests implemented in Java using the **RestAssured** library and **JUnit** framework. These tests demonstrate basic GET and POST requests, including authentication testing against public dummy APIs.

---

## Test Class: `ApiTest`

Located in package: `com.example`

### Tests Included:

1. **testGetPost**  
   - Sends a GET request to `https://jsonplaceholder.typicode.com/posts/1`  
   - Verifies the response status is `200 OK` and the post `id` is `1`.

2. **testPostRequest**  
   - Sends a POST request to `https://jsonplaceholder.typicode.com/posts` with a JSON body  
   - Verifies the response status is `201 Created` and the `title` in response matches the request.

3. **testPostRequestResults**  
   - Sends the same POST request as above  
   - Prints the full response body  
   - Verifies multiple fields (`title`, `body`, `userId`, and that an `id` is returned)

4. **testUserAuth**  
   - Sends a POST request to `https://dummyjson.com/auth/login` with user credentials  
   - Verifies the response status is `200 OK` and a `token` is returned in the response  
   - Prints the received authentication token

---

## Prerequisites

- Java JDK 8 or higher
- Maven or Gradle build tool
- Internet connection (to access the public APIs)
- IDE or text editor (e.g., IntelliJ IDEA, Eclipse)

---

## Dependencies

The project requires the following dependencies (shown here for Maven):

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
