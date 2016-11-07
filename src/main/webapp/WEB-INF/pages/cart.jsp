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

<div class="container">
  <table id="cart" class="table table-hover table-condensed">
    <thead>
    <tr>
      <th style="width:50%">Product</th>
      <th style="width:10%">Price</th>
      <th style="width:8%">Quantity</th>
      <th style="width:22%" class="text-center">Subtotal</th>
      <th style="width:10%"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="listValue" items="${lists}">
    <tr>
      <td data-th="Product">
        <div class="row">
          <div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
          <div class="col-sm-10">
            <h4 class="nomargin">${listValue.title}</h4>
            <p>${listValue.description}</p>
          </div>
        </div>
      </td>
      <td data-th="Price">$${listValue.price}</td>
      <td data-th="Quantity">
        <input type="number" class="form-control text-center" value="1">
      </td>
      <td data-th="Subtotal" class="text-center">1.99</td>
      <td class="actions" data-th="">
        <button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
        <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
      </td>
    </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr class="visible-xs">
      <td class="text-center"><strong>Total 1.99</strong></td>
    </tr>
    <tr>
      <td><a href="/index" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
      <td colspan="2" class="hidden-xs"></td>
      <td class="hidden-xs text-center"><strong>Total $1.99</strong></td>
      <td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
    </tr>
    </tfoot>
  </table>
</div>
</body>
</html>
