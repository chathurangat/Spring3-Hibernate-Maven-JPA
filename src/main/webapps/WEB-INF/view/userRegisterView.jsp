<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head><title><spring:message code="registration.page.name"/></title>
</head>
<body>

<form:form commandName="user" method="POST" action="register">

    <p><spring:message code="registration.form.header"/> </p>
    <form:label path="username"><spring:message code="registration.label.username"/></form:label>
    <form:input path="username"/>
    <form:errors path="username"/>
    <br/>

    <form:label path="password"><spring:message code="registration.label.password"/></form:label>
    <form:password path="password"/>
    <form:errors path="password"/>
    <br/>

    <form:label path="email"><spring:message code="registration.label.email"/></form:label>
    <form:input path="email"/>
    <form:errors path="email"/>
    </br>
    <input type="submit" value="register" />

</form:form>

<spring:message code="registration.page.copyright.information"/>

</body>
</html>