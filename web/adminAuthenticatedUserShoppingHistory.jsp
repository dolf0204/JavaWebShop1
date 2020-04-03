<head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    
    <script src="adminShoppingHistory.js"></script>
    <link rel="stylesheet" type="text/css" href="ShoppingHistory.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
  

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

    <script src="jquery_cookie.js" type="text/javascript"></script>

    <script src="lightslider.js" type="text/javascript"></script>
<script src="https://js.api.here.com/v3/3.1/mapsjs-core.js"
  type="text/javascript" charset="utf-8"></script>
<script src="https://js.api.here.com/v3/3.1/mapsjs-service.js"
  type="text/javascript" charset="utf-8"></script>
  
 

 
  <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>




    </head>
    <body>
       <%@include file="adminHeader.jsp" %>;
            <div id="MainScreenMainContainer">
                <div id="filterContainer">
                   
                <div id="MainScreenUpperSection">
                    <h3>Enter username</h3>
                    <form autocomplete="off" >
                      <div class="autocomplete" style="width:300px;">
                        <input id="myInput" type="text" name="user" placeholder="User">
                      </div>
                    </form>
                    <div id="btnContainer">
                <button class="btn btn-primary" onclick="setSingleUser()"  id="btnGetUser">Get User </button>
                 <button class="btn btn-primary" onclick="setUsers()"  id="btnGetUser">Get All Users </button>
                </div>
                    
                </div>
                    <div id="calendarContainer">
                          <h3>Enter date</h3>
                            
       <div class="container">
          <div class="row">
            <div class='col-sm-6'>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
            </div>
            
          </div>
       </div>
                           <button class="btn btn-primary" onclick="getDate()"  id="btnGetDate">Get</button>

                    </div>
                    </div>
                <div id="MainScreenMiddleSection">
                     <h3>All users</h3>
           <div id="tableContainer">
                    <table class="table table-dark table-striped" id="myTable">
                         <thead>
              <tr>
                <th scope="col">Username</th>
                <th scope="col">Shopping date</th>
                <th scope="col">Total price</th>                       
               <th scope="col">Payment method</th>
               <th scope="col">Details</th>
              </tr>
            </thead>
            <tbody></tbody>
                    </table>
                        </div>

                <div class="clearfix"></div>

                </div>
                    <div style="text-align:center;">
    <input type="button" id="first" onclick="firstPage()" value="first" />
    <input type="button" id="next" onclick="nextPage()" value="next" />
    <input type="button" id="previous" onclick="previousPage()" value="previous" />
    <input type="button" id="last" onclick="lastPage()" value="last" />

    <div id="list"></div>
    </div>
        
        </div>


<!-- Footer -->
<!-- Footer -->
<footer class="page-footer font-small unique-color-dark" id="footer">

  <div id="socialMediaContainer" >
    <div class="container">

     
      <div class="row py-4 d-flex align-items-center">

        
        <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
          <h4 class="mb-0" id="socialMediaText">Social networks</h6>
        </div>
       
        <div class="col-md-6 col-lg-7 text-center text-md-right">

         <ul class="nav navbar-nav" id="navFooter">
          <li><a href="#"><img alt="Brand" src="Pictures/facebook.jpg" id="fb"> </a></li>
          <li><a href="#"><img alt="Brand" src="Pictures/twitter.jpg" id="twitter"> </a></li>
          <li><a href="#"><img alt="Brand" src="Pictures/instagram.jpg" id="instagram"> </a></li>
          <li><a href="#"><img alt="Brand" src="Pictures/whatsupp.png" id="whatsupp"> </a></li>
         </ul>

        </div>
     

      </div>


    </div>
  </div>


  <div class="container text-center text-md-left mt-5">

  
    <div class="row mt-3">

    
      <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

      
        <h6 class="companyName">Good drugs</h6>
        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
        <p class="companyName">The best drugs and medical supplies on the market
        </p>

      </div>
      


      <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

      
        <h6 class="companyName">Informations</h6>
        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
        <p>
          <a href="#">FAQ</a>
        </p>
        <p>
          <a href="#">About us</a>
        </p>
        <p>
          <a href="#l">Responsible taking drugs</a>
        </p>
        <p>
          <a href="#!">Medical asistence</a>
        </p>

      </div>
 
      <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

   
        <h6 class="companyName">Useful links</h6>
        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
        <p>
          <a href="#!">Your Account</a>
        </p>
        <p>
          <a href="#!">Become an Affiliate</a>
        </p>
        <p>
          <a href="#!">Shipping Rates</a>
        </p>
        <p>
          <a href="#!">Help</a>
        </p>

      </div>
 
      <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

        
        <h6 class="companyName">Contact</h6>
        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
        <p class="companyName">
          <i class="companyName"></i>Zagreb, Ljubljanica 14</p>
        <p class="companyName">
          <i class="companyName"></i>rudigum@gmail.com</p>
        <p class="companyName">
          <i class="companyName"></i> + 01 528 567 </p>
        <p class="companyName">
          <i class="companyName"></i> + 91 538 22 55</p>

      </div>


    </div>


  </div>
 



</footer>
  <!-- Footer -->
  
  <div class="modal" id="myModal" role="dialog">
  <div class="modal-dialog">
  
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 id="modalHeader" class="modal-title"></h4>
      </div>
      <div class="modal-body">
        <p id="modalBody"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal()">Close</button>
      </div>
    </div>
    
  </div>
</div>
  
 
    </body>

    