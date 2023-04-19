<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>

        User Logged: ${userLogged.login}

        <br>
        <br>
        <br>

         <c:if test="${not empty company}">
            Company ${ company } Sucessfull create!
         </c:if>

         Companies list: <br/>

    <ul>
        <c:forEach items="${companies}" var="company">

            <li>${company.name} - <fmt:formatDate value="${company.openDate}" pattern="MM/dd/yyyy"/>
                <a href="/manager/entrance?action=ShowCompany&id=${company.id}">edit</a>
                <a href="/manager/entrance?action=RemoveCompany&id=${company.id}">delete</a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>