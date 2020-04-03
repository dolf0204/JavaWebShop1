<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>  
   
    <script src="registration.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script> 
    <link rel="stylesheet" type="text/css" href="MainScreen.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
   
    <script src="../../Scripts/jquery_cookie.js" type="text/javascript"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
   
  
<script src="jquery_cookie.js" type="text/javascript"></script>



    </head>
    <body>
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
                   <li><a href="userHistory.jsp">User history</a></li>
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
        <div id="MainScreenMainContainer">

            <h1 id="RegistrationHeading">Registration</h1>
            <div id="RegistrationContainer">
                
                      
                <form id="form1" action="registrationServlet" method="POST"  role="form" class="form-horizontal">
                    
                   
                  
                <div class="form-group">
                  <label for="username">Username:</label>
                  <input type="text" name="username"  class="form-control" id="usr">
                </div>
                <div class="form-group">
                  <label for="password">Password:</label>
                  <input type="password" name="password" class="form-control" id="pwd">
                </div>
               
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" name="name" class="form-control" id="name">
                  </div>
                  <div class="form-group">
                    <label for="surname">Surname:</label>
                    <input type="text" name="surname" class="form-control" id="surname">
                  </div>
                  <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name="email" class="form-control" id="email">
                  </div>
                <div class="form-group">
                  <label for="birthDate">Phone:</label>
                  <input type="number" name="phone" class="form-control" id="bDay">
                </div>
                
                <div class="form-group">
                  <label for="passportNumber">Adress:</label>
                  <input type="adress" name="adress" class="form-control" id="passNumber">
                </div>
               
                
                 <input type="submit" class="btn btn-primary" value="Register"  id="btnSubmitRegistration" > 
                
                
                </form>
               
                
            </div>
           

          </div>
        </div>
       

<!-- Footer -->
<%@include file="footer.jsp" %>;
  <!-- Footer -->

   
 
    </body>

    