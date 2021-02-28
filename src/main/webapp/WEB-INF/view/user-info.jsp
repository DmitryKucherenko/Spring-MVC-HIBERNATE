<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
   <form:form action="saveUser" modelAttribute="user">
       <form:hidden path="id"/>
       Name<form:input path="name"/>
       <br><br>
       Age<form:input path="age"/>
       <br><br>
       IsAdmin?<form:input path="admin"/>
       <br><br>
       CreatedDate<form:input path="createdDate"/>
       <br><br>
       <input type="submit" value="save">
       
   </form:form>

</body>
</html>
