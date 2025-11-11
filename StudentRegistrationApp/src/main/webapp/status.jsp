<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Status</title>

<style>
  * {
    box-sizing: border-box;
    font-family: "Poppins", sans-serif;
  }

  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background: linear-gradient(135deg, #00bcd4, #009688);
  }

  .box {
    background: #fff;
    color: #333;
    padding: 30px 25px;
    border-radius: 15px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.3);
    text-align: center;
    width: 380px;
  }

  h2 {
    font-size: 24px;
    color: #00796b;
    margin-bottom: 15px;
  }

  .success { color: green; font-weight: bold; }
  .fail { color: red; font-weight: bold; }
  .error { color: darkred; font-weight: bold; }

  a {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    color: #00796b;
    font-weight: 600;
  }

  a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>

  <div class="box">
    <%
        String status = (String) request.getAttribute("status");
        String message = (String) request.getAttribute("message");
        String name = (String) request.getAttribute("name");
    %>

    <h2><%= message != null ? message : "Registration Status" %></h2>

    <% 
        if ("success".equals(status)) {
    %>
        <p class="success">Welcome, <%= name %>!</p>
    <%
        } else if ("fail".equals(status)) {
    %>
        <p class="fail">Please try again later.</p>
    <%
        } else {
    %>
        <p class="error">Something went wrong. Please try again.</p>
    <%
        }
    %>

    <a href="index.html">Go Back</a>
  </div>

</body>
</html>
