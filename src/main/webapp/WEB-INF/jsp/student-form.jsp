<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>First Web Application</title>
</head>

<body>


<%--@elvariable id="student" type="com.amin.demo.models.Student"--%>
<form:form action="processForm" modelAttribute="student">
    <div><h1>Fill the form</h1></div>
    <br/>
   First Name <form:input path="firstName"/>
    <form:errors path="firstName" cssStyle="color: red" cssClass="error"/>
    <br/>
   Last Name <form:input path="lastName"/>
    <form:errors path="lastName" cssStyle="color: red" cssClass="error"/>
    <br/>
    Free Passes <form:input path="email"/>
    <form:errors path="email" cssStyle="color: red" cssClass="error"/>
    <input type="submit" value="Submit">
</form:form>
</body>

</html>