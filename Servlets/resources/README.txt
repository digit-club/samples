Servlets:

(good article) http://java-course.ru/student/book1/servlet/

TCP/IP - HTTP

1) download tomcat 8:
http://tomcat.apache.org/download-80.cgi

run tomcat:
sh <TOMCAT_HOME>/bin/catalina.sh run

check 8080 port

2) create project. Create pakage servlets with class MyExampleServlet extended from HttpServlet
- add library for servlet-api

3) compile 

4) copy out/production/ProjectName -> servlets/MyExampleServlet.class file to /webapps/my-server/WEB-INF/classes

5) add mapping to web.xml

update /webapps/examples/WEB-INF/web.xml with the following

	<servlet>
        <servlet-name>Example</servlet-name>
        <servlet-class>servlets.MyExampleServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>Example</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>


6) hit http://localhost:8080/my-server/hello