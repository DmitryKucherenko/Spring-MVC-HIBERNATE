<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users</title>
</head>
<body>
<form action="search" method="get">
    <input type="text" name="searchName" style="margin-top:20px;width:500px"><input type="submit" value="search" style="width:100px" >
</form>

  <table cellpadding="0" cellspacing="0" border="1" style="text-align: center;margin-top:20px;width:600px">
     <tr>
         <th>№</th>
         <th>name</th>
         <th>age</th>
         <th>is admin?</th>
         <th>created date</th>
         <th >Operation</th>
     </tr>
        <c:forEach items="${allUsers}" var="user" varStatus="сounter">

            <c:url var="updateButton" value="/updateUser">
                <c:param name="usrId" value="${user.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteUser">
                <c:param name="usrId" value="${user.id}"/>
            </c:url>

            <tr>
                <td><c:out value="${сounter.count}"/></td>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.age}"></c:out></td>
                <td><c:out value="${user.admin}"></c:out></td>
                <td><c:out value="${user.createdDate}"></c:out></td>
                <td ><input type="button" value="Update" onClick="window.location.href='${updateButton}'">
                <input type="button" value="Delete" onClick="window.location.href='${deleteButton}'"></td>

            </tr>



        </c:forEach>


  </table>
<br><br>
<input type="button" value="Add" onClick="window.location.href='/addUser'">
</body>
</html>
