<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.WelcomeController,
                 model.Gun,
                 java.util.Collection" %>
<html>
<head>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Welcome to our gun shop!</title>
</head>
<body>

<%
    Collection<Gun> guns = (Collection<Gun>) request.getAttribute(WelcomeController.ALL_GUNS_KEY);
%>

Это наши пушки:
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>Date of Birth</th>
        <th>is used</th>
        <th>Delivery date</th>
    </tr>
    <%
        for (Gun gun : guns) {
    %>
    <tr>
        <td><%=gun.getId()%></td>
        <td><%=gun.getModel().getName()%></td>
        <td><%=gun.getDob()%></td>
        <td><%=gun.isUsed()%></td>
        <td><%=gun.getDeliveryDate()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
