<%-- 
    Document   : logged
    Created on : Sep 20, 2019, 9:24:30 AM
    Author     : sanjeewa_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Hello <s:property value="user.username"></s:property></p>
    </body>
</html>
