<head>
        
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="userHistory.js"></script>
    <link rel="stylesheet" type="text/css" href="Products.css">
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
              
              <h1 id="mainText">Shopping history</h1>
              <h3 id="mainText">List of all your shoppings </h3>

          </div>
               <div id="MainScreenMiddleSection">
              <label for="dates">Choose date</label>

                <select id="dates">
                  
                
                </select>
               <button id='getItems' class='btn btn-primary' onclick='getCartItems(dates.options[dates.selectedIndex].value)'>Get</button>
                
                </div>
                <div id="MainScreenLowerSection">
                             <table class="table table-dark table-striped" id="myTable">
                         <thead>
              <tr>
                <th scope="col">Name</th>
                <th scope="col">Amount</th>
                <th scope="col">Price</th>
               
                

            
                              
               
              </tr>
            </thead>
            <tbody></tbody>
                    </table>
                    
                </div>
            
                
            
        </div>
       

<!-- Footer -->
<%@include file="footer.jsp" %>;
 
    </body>

    