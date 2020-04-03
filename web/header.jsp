
  
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
                  <li><a href="mainScreenAfterLogin.jsp">Home<span class="sr-only">(current)</span></a></li>
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
                  <ul class="nav navbar-nav navbar-right">
                 
                  <li>
                    <p id="welcomeMsg"></p>
                    <p id="settings"></p>
                    <span id="signOut"></span>
                    

                  </li>
                  
             
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

