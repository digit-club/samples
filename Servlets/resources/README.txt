Servlets:

(good article) http://java-course.ru/student/book1/servlet/

1) download tomcat 8:
http://tomcat.apache.org/download-80.cgi

run tomcat:
sh <TOMCAT_HOME>/bin/catalina.sh run (this way you see logs in console and can easily stop tomcat)

check 8080 port. Starter page appearance means that you set up tomcat successfully.

Stop it using Ctrl+Z (C) combination.

2) create project from cloned repo. Add library servlet-api: select File -> Project Structure -> Project Settings -> Libraries -> '+' -> Java -> chose from <TOMCAT_HOME>/lib/servlet-api.jar

3) compile project

How to deploy:

4) Create directory structure <TOMCAT_HOME>/webapps/my-server/WEB-INF/classes

5) copy out/production/Servlets/servlets directory (servlets/MyExampleServlet.class) into -> <TOMCAT_HOME>/webapps/my-server/WEB-INF/classes

6) create file <TOMCAT_HOME>/webapps/my-server/WEB-INF/web.xml with the following

<web-app>
    <servlet>
        <servlet-name>Example</servlet-name>
        <servlet-class>servlets.MyExampleServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>Example</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>

Or just copy it from resources/web.xml

7) Start tomcat

8) hit http://localhost:8080/my-server/hello
