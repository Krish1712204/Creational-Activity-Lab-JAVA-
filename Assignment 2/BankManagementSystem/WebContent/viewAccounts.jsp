<%@ page import="java.util.*, model.Account" %>
<html>
<head><title>View Accounts</title></head>
<body>
    <h2>Bank Accounts</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Balance</th></tr>
        <%
            List<Account> accounts = (List<Account>) request.getAttribute("accountList");
            for (Account acc : accounts) {
        %>
        <tr>
            <td><%= acc.getId() %></td>
            <td><%= acc.getName() %></td>
            <td><%= acc.getBalance() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>