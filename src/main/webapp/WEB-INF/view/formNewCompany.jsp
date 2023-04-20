<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrance" var="linkEntranceServlet"/>
<html>
<body>

    <c:import url="logout-partial.jsp"/>

    <form action="${linkEntranceServlet}" method="post">

        Company name: <input type="text" name="Company name"/>
        Open Date: <input type="text" name="date">

        <input type="hidden" name="action" value="NewCompany" >

        <input type="submit"/>

    </form>
</body>
</html>