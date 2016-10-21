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
    <!-- Navigation -->
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">OnlineShop</a>
            </div>
                <div class="navbar-collapse collapse" id="navbar-main">
                    <form class="navbar-form navbar-right" role="search">
                        <button type="submit" class="btn btn-default">Sign In</button>
                    </form>
                </div>
        </div>
    </div>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                    <a href="/index?category=category1" class="list-group-item">Category 1</a>
                    <a href="/index?category=category2" class="list-group-item">Category 2</a>
                    <a href="/index?category=category3" class="list-group-item">Category 3</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <c:forEach var="listValue" items="${lists}">
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <cl:image src="320x150_e1zkhm" format="jpg" width="320" height="150" crop="fill"/>
                                <div class="caption">
                                    <h4 class="pull-right">$${listValue.price}</h4>
                                    <h4><a href="#">${listValue.title}</a>
                                    </h4>
                                    <p>${listValue.description}</p>
                                </div>
                                <div class="ratings">
                                    <p class="pull-right">${listValue.views} reviews</p>
                                    <p>
                                        <c:forEach begin="1" end="${listValue.stars}" varStatus="loop">
                                            <span class="glyphicon glyphicon-star"></span>
                                        </c:forEach>
                                        <c:forEach begin="${listValue.stars + 1}" end="5" varStatus="loop">
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </c:forEach>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>

</body>

</html>
