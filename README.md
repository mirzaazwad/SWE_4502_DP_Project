# SWE_4502_DP_Project
This directory contains the project duck simulator for SWE_4502 Design Project. The Task is as follows:
1. First they have to create a Quackable interface. Some Ducks that implement Quackable
Interface
2. After that they will create an adapter to adapt a goose to a duck.
3. Next for some research purpose we want to count the number of quacks of a duck. They
will create a decorator that gives the ducks this new behavior by wrapping them with a
decorator object.
4. Create a duck factory and a counting duck factory.
5. To create a flock of ducks use a Composite Pattern that allows us to treat a collection of
objects in the same way as individual objects (use iterator).
6. We also need to track individual ducks. Can you give us a way to keep track of individual
duck quacking in real time? (use observer)

This system makes use of github actions for testing

To run this application in your local machine preferably download the apache maven binary or use intelliJ.

## To setup apache maven in your local machine you can follow the steps given below:

### Windows

1. Download the apache maven binary from the following link: [Apache Maven](https://maven.apache.org/download.cgi)

2. Extract the downloaded bin file and then add the path to bin folder within the extracted directory to your system environment variables

3. For VsCode you can get the "Maven for Java" extension provided by Microsoft to get the flavors of IntelliJ

4. Upon adding to the system environment variables you can check using 

```
mvn --version
```

To confirm your installation.

5. Then just go to the cloned/downloaded project directory and write 
```
mvn clean install
```

6. To execute the code just simply write
```
mvn exec:java
```
It will essentially execute the main class

### Linux

1. Install maven simply by using
```
sudo apt-get install maven
```

2. Follow steps 3 to 6 for Windows

### Mac

For MAC installation, you can refer to this [article](https://www.baeldung.com/install-maven-on-windows-linux-mac)
