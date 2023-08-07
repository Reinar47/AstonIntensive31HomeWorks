<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Find Teachers</title>
</head>
<body>

<h2>Find Teacher</h2>

<form action="/Find teacher" method="post">
  <table>
    <tr>
      <td>Course Name:</td>
      <td><input type="text" name="courseName" maxlength="30" size="25" /></td>
    </tr>
  </table>
</form>
<br />
<input type="button" value="Return to Home"
       onclick="window.location.href='home.jsp'" />

<h1>Teachers</h1>
<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Working now</th>
  </tr>
  <jsp:useBean id="teacherList" scope="request" type="java.util.List"/>
  <c:forEach var="teacher" items="${teacherList}">
    <tr>
      <td>${teacher.firstName}</td>
      <td>${teacher.lastName}</td>
      <td>${teacher.isTeacher}</td>
    </tr>
  </c:forEach>
</table>
</body>

</html>
