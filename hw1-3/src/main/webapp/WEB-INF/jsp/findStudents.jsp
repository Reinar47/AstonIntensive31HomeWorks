<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Find Students</title>
</head>
<body>

<h2>Find Students</h2>

<form action="/Find student" method="post">
    <table>
        <tr>
            <td>Course Name:</td>
            <td><input type="text" name="courseName" maxlength="30" size="25" /></td>
        </tr>
    </table>
    <br /> <input type="submit" value="Find" />
</form>
<br />

<h1>Students</h1>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>On Course now</th>
    </tr>
    <jsp:useBean id="studentList" scope="request" type="java.util.List"/>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.isStudent}</td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
