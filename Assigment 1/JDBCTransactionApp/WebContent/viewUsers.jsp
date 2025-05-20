<%@ page import="java.util.*, model.User" %>
<%@ page isELIgnored="false" %>
<html>
<head><title>View Users</title></head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Action</th></tr>
        <%
            List<User> users = (List<User>) request.getAttribute("userList");
            for (User u : users) {
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
            <td>
                <form action="UserController" method="post">
                    <input type="hidden" name="action" value="delete" />
                    <input type="hidden" name="id" value="<%= u.getId() %>" />
                    <input type="submit" value="Delete" />
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>