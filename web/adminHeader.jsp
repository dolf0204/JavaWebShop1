
  
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
                  <li><a href="adminMainScreenAfterLogIn.jsp">Home<span class="sr-only">(current)</span></a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shopping history<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                     

                      <li role="separator" class="divider"></li>

                      <li><a href="adminAuthenticatedUserShoppingHistory.jsp">Authenticated user</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="adminNotAuthenticatedUserShoppingHistory.jsp">Anonymous user</a></li>
                      <li role="separator" class="divider"></li>
                      
              
                    </ul>
                  </li>
                  <li><a href="adminUserList.jsp">User list</a></li>
                   <li><a href="adminLogInHistory.jsp">Log in history</a></li>
                 

                
                </ul>
                  <ul class="nav navbar-nav navbar-right">
                 
                  <li>
                    <p id="welcomeMsg"></p>
                    <p id="settings"></p>
                    <span id="signOut"></span>
                    

                  </li>
                  
             
                </ul>
              
                
              </div>
            </div>
          </nav>
    </header>

