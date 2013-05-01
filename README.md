# Webservice Workflow Project

---
## Determinant Calculator

The workflow consists of 3 services:

* SquareMatrixValidator
* LUDecomposer
* DeterminantCalc

Requirements
---
* JDK 6
* Apache Ant  
*tested with Ant 1.8.2*
* Tomcat 7   
*tested with Tomcat 7.0.39 with no modifications*


Build instructions
-
* Compile the source code by running `ant` from the root of the ServiceWorkflow folder

* Copy the compiled source directories `out/artifacts/client` and `out/artifacts/services` to your `<Tomcat 7 home>/webapps/` directory.

* Start the tomcat server by running `<Tomcat 7 home>/bin/catalina.sh start`
 
* Open `http://localhost:8080/client/workflow.do` in a browser to reach the client


#####Example ( OS X 10.8.2 )

    $ rm -rf out/
    $ ant
    $ cp -r out/artifacts/ /Library/Tomcat/apache-tomcat-7.0.39/webapps
    $ /Library/Tomcat/apache-tomcat-7.0.39/bin/catalina.sh run



Exception Handlers
-
Developed by:

* Roman Birg
* John Bohne
* Doug Rowell
 

######Spring 2013
*University of Memphis - COMP 4302*
