<%--
  Created by IntelliJ IDEA.
  User: zhanghaiwei
  Date: 2015/8/23
  Time: 18:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/login" method="post">
  username:<input type="text" name="username" value="" /><br/>
  password:<input type="password" name="password" value="" /><br/>
  <input type="submit" value="登录" />

</form>
</body>
</html>
