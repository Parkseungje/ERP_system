<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
  <display-name>Servlet 3.0 Web Application</display-name>
  
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>/WEB-INF/applicationContext.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
    <!-- 웹소켓을 위한 설정(비동기지원) -->
    <async-supported>true</async-supported>
    
  </servlet>
  
  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  
  <session-config>
  	<session-timeout>720</session-timeout>
  </session-config>

  <jsp-config>
    <taglib>
        <taglib-uri>
            /WEB-INF/tlds/CommonUtil.tld
        </taglib-uri>
        <taglib-location>
            /WEB-INF/tlds/CommonUtil.tld
        </taglib-location>    
    </taglib>
  </jsp-config>
  
 
	<error-page>
	    <error-code>404</error-code>
	    <location>/WEB-INF/view/common/error/error404.jsp</location>
	</error-page>
	
	<error-page>
	    <error-code>500</error-code>
	    <location>/WEB-INF/view/common/error/error500.jsp</location>
	</error-page>

  
</web-app>