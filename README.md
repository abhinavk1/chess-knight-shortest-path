# Chess Knight Shortest Path

This application generates a distance graph which is a matrix of numbers that shows the minimum number of
turns it takes for a knight in a given starting position (x0, y0) to reach the coordinate in the matrix. If the
coordinate is unreachable, we denote it with -1. 

### Technology Specification
1. This project is built using Java 8.
2. Maven is used to build the JAR file.
3. The only dependency this project has is JUnit for running test cases. When running the tests, 
maven will fetch the JUnit dependencies by itself.

### Steps to build and run the Application
1. Navigate to the root directory
2. Build the application JAR file using Maven <br />
   ```shell 
   mvn package
   ```
3. Navigate to the *target* directory and run the JAR file
   ```shell 
      java -jar distance-graph-1.0.jar <arg0> <arg1> <arg2> <arg3> 
   ```
   where <arg0> = length of the chess board,
         <arg1> = width of the chess board,
         <arg2> = starting X coordinate,
         <arg3> = starting Y coordinate,
4. To run the test cases, use this command when in the root directory
   ```shell 
      mvn test
   ```
