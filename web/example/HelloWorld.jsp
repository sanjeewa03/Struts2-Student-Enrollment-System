<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title>
    <style>
      .mycheckbox:focus{
        border: 2px solid red;
  border-radius: 4px;
      }

  </style>
    <s:head />
  </head>
  <body>
    <h3>Login.</h3>
    

    <s:form action="/Login">
        <s:textfield name="user.username" label="Username" cssClass="mycheckbox" />
        <s:textfield name="user.password" label="Password" cssClass="mycheckbox" />
      <s:submit/>
    </s:form>	
    <s:property value="error.error" ></s:property>
  </body>
</html>
