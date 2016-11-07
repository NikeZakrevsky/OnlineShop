<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap Core CSS -->
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Custom CSS -->
  <link href="/resources/css/shop-homepage.css" rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}"
         value="${_csrf.token}" />
</form>
<script>
  function formSubmit() {
    document.getElementById("logoutForm").submit();
  }
</script>
<!-- Navigation -->
<div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/index">OnlineShop</a>
    </div>
    <form class="navbar-form navbar-right" role="search" action="/shopingCart">
      <button type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart
      </button>
    </form>
    <div class="navbar-collapse navbar-right navbar-brand" id="navbar-main">
      <div class="navbar-header">
        <c:if test="${not empty pageContext.request.userPrincipal.name}">
          User : ${pageContext.request.userPrincipal.name} | <a href = "javascript:formSubmit()"> Logout</a>
        </c:if>
      </div>
    </div>
    <c:if test="${empty pageContext.request.userPrincipal.name}">
      <form class="navbar-form navbar-right" role="search" action="/login">
        <button type="submit" class="btn btn-default">Sign In</button>
      </form>
    </c:if>
  </div>
</div>
<c:forEach var="listValue" items="${lists}">
  <h4>${listValue.title}</h4>
</c:forEach>
</body>
</html>
