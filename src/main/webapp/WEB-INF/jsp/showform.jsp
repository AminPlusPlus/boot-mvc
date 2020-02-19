<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>First Web Application</title>
</head>

<body>


<%--@elvariable id="customer" type="com.amin.demo.models.Customer"--%>
<form:form action="processForm" modelAttribute="customer">
    <div><h1>Fill the form</h1></div>
    <br/>
   First Name <form:input path="firstName"/>
    <br/>
   Last Name <form:input path="lastName"/>
    <form:errors path="lastName" cssStyle="color: red" cssClass="error"/>
    <br/>
    Free Passes <form:input path="freePass"/>
    <form:errors path="freePass" cssStyle="color: red" cssClass="error"/>
    <br/>
    Postal Code <form:input path="postalCode"/>
    <form:errors path="postalCode" cssStyle="color: red" cssClass="error"/>
    <br/>
    Course Code <form:input path="courseCo›de"/>
    <form:errors path="courseCode" cssStyle="color: red" cssClass="error"/>
    <br/>
    <input type="submit" value="Submit">
</form:form>
</body>

</html>