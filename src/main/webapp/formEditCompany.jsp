<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/editCompany" var="linkServletNewCompany"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="${linkServletNewCompany}" method="post">

            Company name: <input type="text" name="Company name" value="${company.name}" />
            Open Date: <input type="text" name="date" value="<fmt:formatDate value="${company.openDate}" pattern="MM/dd/yyyy"/>" />
            <input type="hidden" name=id" value="${company.id}">
            <input type="submit" />
        </form>

</body>
</html>
