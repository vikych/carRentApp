<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="js/bootstrap-3.3.6-dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="js/font-awesome-4.5.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    <script src="/js/homepage.js"></script>
    <script type='text/javascript' src='js/knockout-3.4.2.js'></script>
    <script type="text/javascript" src="js/numeric/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/numeric/jquery.numeric.js"></script>
</head>
<body data-bind="click: $root.function.ClosePopUpWindow">
<div id="HomePageContainer">
    <div class="allcontain">
        <div class="header">
            <ul class="socialicon">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
            </ul>
            <ul class="logreg">
                <li>Give us a call : +371 29846263</li>
            </ul>
        </div>
        <nav class="topnavbar navbar-default topnav">
            <div class="collapse navbar-collapse" id="upmenu">
                <ul class="nav navbar-nav" id="navbarontop">
                    <li class="active"><a href="homepage.html">HOME</a></li>
                    <li class="active"><a href="carlist.html">CAR LIST</a></li>
                    <li class="active"><a href="rentacar.html">RENT A CAR</a></li>
                    <li class="active"><a href="rentalhistory.html">RENTAL HISTORY</a></li>
                    <li class="active"><a href="editprofile.html">EDIT PROFILE</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="allcontain">
        <div id="carousel-up" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner " role="listbox">
                <div class="item active">
                    <img src="css/image/car_slider_1.jpg" alt="oldcar">
                </div>
                <div class="item">
                    <img src="css/image/car_slider_2.jpg" alt="porche">
                </div>
                <div class="item">
                    <img src="css/image/car_slider_3.jpg" alt="benz">
                </div>
                <div class="item">
                    <img src="css/image/car_slider_4.jpg" alt="benz">
                </div>
                <div class="item">
                    <img src="css/image/car_slider_5.jpg" alt="benz">
                </div>
            </div>
            <nav class="navbar navbar-default midle-nav">
                <div class="collapse navbar-collapse" id="navbarmidle">
                    <div class="searchtxt">
                        <h1>CAR SEARCH</h1>
                    </div>
                    <form class="navbar-form navbar-left searchformmargin" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control searchform" placeholder="Manufacturer">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control searchform" placeholder="Model">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control searchform inputYear" placeholder="Year">
                        </div>
                    </form>
                    <ul class="nav navbar-nav navbarborder">
                        <li class="li-search">
                            <button class="searchbutton"><span class="glyphicon glyphicon-search "></span></button>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <div class="cd-popup" role="alert">
        <div class="cd-popup-container">
            <p>Welcome, <b>${tusername}</b></p>
            <a class="cd-popup-close img-replace" style="cursor:pointer;" data-bind="click: $root.function.ClosePopUpWindow">Close</a>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    (function () {
        function HomePageViewModel() {
            var self = this;
            self.function = {
                GetGreetingMSG: function () {
                    $('.cd-popup').addClass('is-visible');
                },
                ClosePopUpWindow: function () {
                    $('.cd-popup').removeClass('is-visible');
                }
            }
        }
        var model = new HomePageViewModel();
        model.function.GetGreetingMSG();
        ko.applyBindings(model, document.getElementById("HomePageContainer"));
    })();
</script>