#Determinant Calculator Service Workflow

---

Requirements
-
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
 
* Open `http://localhost:8080/client/workflow` in a browser to reach the client
 
***


Exception Handlers
-
* Roman Birg
* John Bohne
* Doug Rowell

######Spring 2013
*University of Memphis - COMP 4302*
