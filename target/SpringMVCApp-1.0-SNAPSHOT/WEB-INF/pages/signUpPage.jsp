<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <title>Login Page</title>
</head>
<body>
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
    <div class="navbar-collapse collapse" id="navbar-main">
      <form class="navbar-form navbar-right" role="search" action="/login">
        <button type="submit" class="btn btn-default">Sign In</button>
      </form>
    </div>
  </div>
</div>
<div class="container" style="margin-top:150px;">
      <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title">Sign Up</div>
            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
          </div>
          <div class="panel-body" >


            <form id="signupform" class="form-horizontal" role="form" action="registrate">

              <div id="signupalert" style="display:none" class="alert alert-danger">
                <p>Error:</p>
                <span></span>
              </div>

              <div class="form-group">
                <label for="username" class="col-md-3 control-label">Username</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" name="username" placeholder="Username">
                </div>
              </div>

              <div class="form-group">
                <label for="password" class="col-md-3 control-label">First Name</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" name="password" placeholder="Password">
                </div>
              </div>

              <div class="form-group">
                <!-- Button -->
                <div class="col-md-offset-3 col-md-9">
                  <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i>Sign Up</button>
                </div>
              </div>



            </form>
          </div>
        </div>
        </div>
</div>

</body>
</html>
