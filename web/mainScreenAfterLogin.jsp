<head>
        
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="mainScreenAfterLogIn.js"></script>
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
      
        <%@include file="header.jsp" %>;
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
       

<!-- Footer -->
<%@include file="footer.jsp" %>;
 
    </body>

    