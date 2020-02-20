<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>First Web Application</title>
</head>

<body>
<h1>Search Student</h1>
<br/>

<%--@elvariable id="student" type="com.amin.demo.models.Student"--%>
<form:form action="resultSearchStudent">
    Search by id <input type="text" name="searchId"> <br/>
    <input type="submit"value="Search">
</form:form>

<h3>${resultStudent.toString()}</h3>



</body>

</html>