
<head>
        <meta name="viewport" content="initial-scale=1.0, width=device-width" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
     <script src="mainScreen.js"></script>
    <link rel="stylesheet" type="text/css" href="MainScreen.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
   
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

  <script src="jquery_cookie.js" type="text/javascript"></script>
   <script src="lightslider.js" type="text/javascript"></script>
<script src="https://js.api.here.com/v3/3.1/mapsjs-core.js"
  type="text/javascript" charset="utf-8"></script>
<script src="https://js.api.here.com/v3/3.1/mapsjs-service.js"
  type="text/javascript" charset="utf-8"></script>


    </head>
    <body>

    <header>
        <nav class="navbar navbar-inverse navbar-fixed-top" id="nav">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img alt="Brand" src="Pictures/logo.jpg" id="logo"> 
                    <!-- Brand -->
                </a>
              </div>
          
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li><a href="mainScreen.jsp">Home<span class="sr-only">(current)</span></a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categories<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                     

                      <li role="separator" class="divider"></li>

                      <li><a href="categoryMasks.jsp">Masks</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="categoryInhalators.jsp">Inhalators</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="categoryPills.jsp">Pills</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="categoryGloves.jsp">Gloves</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="categoryCures.jsp">Cures</a></li>
                      <li role="separator" class="divider"></li>
                       <li><a href="categoryMedicalDevices.jsp">Medical devices</a></li>
                      <li role="separator" class="divider"></li>
                       <li><a href="categoryCosmetics.jsp">Cosmetics</a></li>
                      <li role="separator" class="divider"></li>
              
                    </ul>
                  </li>
                  <li><a href="allProducts.jsp">Products</a></li>
                   <li><a href="#">User history</a></li>
                   <li><a href="cart.jsp">Cart</a></li>

                
                </ul>
                <form action="http://localhost:55415/api/LogInPlayer/" method="POST" class="navbar-form navbar-left" id="logInFields">
                  <div class="form-group">
                    <input type="text" id="logInUsrName" name="username" class="form-control" placeholder="Username">
                  </div>
                  <div class="form-group">
                    <input type="password" id="logInPass" name="password" class="form-control" placeholder="Password">
                  </div>
                  
                <button type="button"  id="btnLogIn" class="btn btn-default" onclick="makeACall(document.getElementById('logInUsrName').value,document.getElementById('logInPass').value);">Log in</button>
                  <button type="button"  id="btnRegisterUser" class="btn btn-default" ><a href="registration.jsp">Register</a></button>
                </form>
                
                
              </div>
            </div>
          </nav>
        </header>
        <div id="MainScreenMainContainer">

          <div id="mainScreenUpperSection">
              
              <h1 id="mainText">Welcome to our Medical supply Web Shop</h1>
              <h3 id="mainText">You have the disease, we have the cure! </h3>

          </div>
               <div id="MainScreenMiddleSection">
                <h1 id="mainText">Our newest products</h1>
        <div class="demo">
          <ul id="lightSlider">
              <li>
                  <img src="Pictures/disposableFaceMasksPantryWare.jpg" />
                  <p id="pictureDescription">Package of 20 disposable face masks<a href="products.jsp">Click here</a></p>
                  
              </li>
              <li>
                <img src="Pictures/Wheelchair.jpg" />
                <p id="pictureDescription">Wheelchair Medical Equipment <a href="products.jsp">Click here</a></p>
              
              </li>
              <li>
                <img src="Pictures/AirPhysioNaturalBreathingLungExpander.jpg" />
                <p id="pictureDescription">Mucus Removal Device, Exercise & Cleanse Therapy Aid <a href="products.jsp">Click here</a></p>
              </li>
           
              <li >
                <img src="Pictures/CosmeticDermatologyBook.jpg" />
                <p id="pictureDescription">Hardcover: 384 pages<a href="products.jsp">Click here</a></p>
              </li>
              
          </ul>
      </div>
                 </div>
            <div id="MainScreenLowerContainer">
                <h1 id="mainText">Our location: Ljubljanica 14</h1>
                 <div style="width: 640px; height: 480px" id="mapContainer"></div>
            </div>
        </div>
  </body>
       

<!-- Footer -->
<%@include file="footer.jsp" %>;
  <!-- Footer -->
 
   

    