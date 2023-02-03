<%//scriplet
    String companyName = (String)request.getAttribute("company");
    System.out.println(companyName);
%>

<html>
    <body>
        Company <%=companyName%> Sucessfull create!
    </body>
</html>
