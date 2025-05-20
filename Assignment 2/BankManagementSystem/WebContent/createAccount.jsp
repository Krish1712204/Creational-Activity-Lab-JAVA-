<html>
<head><title>Create Account</title></head>
<body>
    <h2>Create New Bank Account</h2>
    <form action="BankController" method="post">
        <input type="hidden" name="action" value="create" />
        Name: <input type="text" name="name" /><br/>
        Balance: <input type="text" name="balance" /><br/>
        <input type="submit" value="Create Account"/>
    </form>
</body>
</html>