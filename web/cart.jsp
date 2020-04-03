<head>
        
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="cart.js"></script>
    <link rel="stylesheet" type="text/css" href="Products.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    
   
  
   
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
            
                <div id="MainScreenUpperSection">
                    <h1>Your cart</h1>
                    <h3 id="noItems"></h3>
                </div>
                <div id="MainScreenMiddleSection">
                    <div id="tableContainer">
                    <table class="table table-dark table-striped" id="myTable">
                         <thead>
              <tr>
                <th scope="col">Name</th>
                <th scope="col">Amount</th>
                <th scope="col">Price/Item</th>
                <th scope="col">Delete item</th>
                

            
                              
               
              </tr>
            </thead>
            <tbody></tbody>
                    </table>
                        </div>
                </div>
      
        </div>
       

<!-- Footer -->
<%@include file="footer.jsp" %>;
  <!-- Footer -->
 
    </body>

    