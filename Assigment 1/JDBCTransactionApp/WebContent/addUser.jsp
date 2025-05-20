<html>
<head><title>Add User</title></head>
<body>
    <h2>Add User</h2>
    <form action="UserController" method="post">
        <input type="hidden" name="action" value="add" />
        Name: <input type="text" name="name" /><br/>
        Email: <input type="text" name="email" /><br/>
        <input type="submit" value="Add User"/>
    </form>
</body>
</html>