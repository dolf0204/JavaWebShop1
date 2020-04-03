/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var totPrice;
var x = 0;
var name;
var surname;
var adress;
$(function() {
    
   $("#myTable tbody tr").remove();
    
    var id= Cookies.get("user_id");
   
     var loginFields=document.getElementById('logInFields');
    if (id != "null")
    {
    $.ajax({url: "MainScreenAfterLogInServlet",
    method:"GET",
     data:{"id":id},
     success: function(result){
         $(loginFields).css('display','none');
        $('#welcomeMsg').append(result.username);
        $('#settings').append('Settings');
        $('#signOut').append('<a href="mainScreen.jsp" id="signOut" onclick="resetCookie()">Sign off</a>');
        
    
        
      },
      error: function(){
       $(loginFields).css('display','block');
    }
      
      
    });
    
        $.ajax({url: "LogInUserServlet",
    method:"GET",
    dataType : 'json',
     data:{"id":id},
     success: function(result){
     
     name = result.name;
     surname = result.surname;
     adress = result.adress;
     
     }});
  }
  else{
     if (id=="null") {
        id =1;
    }
         $.ajax({url: "LogInUserServlet",
    method:"GET",
    dataType : 'json',
     data:{"id":id},
     success: function(result){
     
     name = result.name;
     surname = result.surname;
     adress = result.adress;
     
     }});
   console.log("Wrong");

}
 });
 function makeACall(logInUsrName,logInPass) { 
    $.ajax({url: "LogInUserServlet",
    method:"POST",
    data:{"username":logInUsrName,"password":logInPass},
     success: function(result){
       
        $.cookie("user_id", result);
    
        window.open("mainScreenAfterLogin.jsp","_self");
      },
      error: function(){
        alert("Wrong username or password");
    }
      
      
    });
    }
 function resetCookie()
{
    $.cookie("user_id", null);
    $.ajax({url: "CartServlet",
    method:"DELETE",
     data:{},
     success: function(result){
         console.log(result);
     }
 });
}
$(function() {

 $.ajax({url: "CartServlet",
    method:"GET",
     data:{},
     success: function(result){
       
       var totalPrice =0;
         $.each(result, function(index, value) {
         
            
            $('#MainScreenMiddleSection').append("<button class='btn btn-primary' value='Proceed' id='proceed' onclick='proceedToPay()'>Proceed</button>");
                if (value == "No items in cart yet") {
                    
                    $('#myTable').css('display','none');
                    
                    
                    $('#noItems').append('No items in cart');
                    
                }
            else
            {
            $('#myTable').append("<tr><td id='idCartItem' style='display:none;'>"+value.idCartItem+"</td>"+
                    "<td>"+value.name+"</td>"+
                    "<td contenteditable='true' id='amount'>"+value.amount+"</td>"+
                    "<td id='ppi'><p id='pricePerItem'>"+(value.price/value.amount).toFixed(2)+"</p><p> $</p></td>"+
                    "<td><button id='deleteItem' onclick='deleteItem("+value.idCartItem+")'>X</button></td></tr>"
                    );
                $('#proceed').css('display','block');
             }
            totalPrice = value.totalPrice;
            totPrice = totalPrice;

         });
    
          $('#myTable').append("<tr><td><b>Total Price: "+totalPrice+" $</b></td></tr>");
          

        
      },
      error: function(){
        alert("Wrongish");
       
        // window.open("mainScreen.jsp","_self");
    }
    
});
});
 function deleteItem(idCartItem)
 {
     $.ajax({url: "DeleteCartItemServlet",
    method:"POST",
     data:{"id":idCartItem},
      dataType : 'json',
      target: '#myModal',
     success: function(result){
         
          $('#modalHeader').append('Sucesefull');
            $('#modalBody').append(result);

            $('#myModal').modal('show');
           // window.open("cart.jsp","_self");

     },
      error: function (result) {
            
            $('#modalHeader').append('Error');
            $('#modalBody').append("Error during registration");

            $('#myModal').modal('show');
           
        }
 });
 }
 function closeModal()
{
   
    window.open("cart.jsp","_self");
    $('#myModal').modal('close');
    
}

function proceedToPay()
 {
     
     totPrice = 0;
     var x = 0;
     $('#myTable > tbody > tr:not(:last-child)').each(function(){
     var idItem = $(this).find('#idCartItem').text();
     var amount = $(this).find('#amount').text();
     var pricePerItem = $(this).find('#pricePerItem').text();
     
     var checkPrice =
     $('#myTable > tbody > tr:nth-last-child(2)').find('#pricePerItem').text();
     //var lastPrice =checkPrice.toFixed(2);
     
     totPrice += (parseFloat(pricePerItem)*parseFloat(amount));
     updateCart(idItem,amount,pricePerItem,checkPrice,totPrice);
     
 

 })
 }
 function updateCart(idItem,amount,pricePerItem,checkPrice,totPrice)
 {
    $.ajax({url: "UpdateCartServlet",
    method:"POST",
    dataType : 'json',
     data:{"idCartItem":idItem,"amount":amount,"totPrice":totPrice,"pricePerItem":pricePerItem},
     success: function(result){
        // totPrice = result;
                if (pricePerItem==checkPrice) {
                    updateTotPrice(totPrice);
                    activateModal(idItem);
                    x++;
                }
         
     }
    
})
 }
     
 function updateTotPrice(totPrice)
 {
    $.ajax({url: "UpdateCartServlet",
    method:"GET",
    dataType : 'json',
     data:{"totPrice":totPrice},
     success: function(result){
         
     }})
 } 
     
     
     
 
 function activateModal(idItem)
 {
          var id= Cookies.get("user_id");  
          if (id=="null") {
              id  = 1;
        
           }
          
    
     $.ajax({url: "CartServlet",
    method:"GET",
    dataType : 'json',
    target: '#myModal',
     data:{},
     success: function(result){
         
                   $('#modalHeader').append('Details');
                   $('#modalBody').append('Order details');
                        $('#modalBody').append("<table class='table table-dark table-striped' id='modalTable'>"+
                         "<thead><tr><th scope='col'>Name</th>"+
                            "<th scope='col'>Amount</th>"+
                            "<th scope='col'>Price</th>"+              
                            " </tr> </thead><tbody>"+

                           "</tbody>  </table>");

                    $.each(result, function(index, value) {
                         $('#modalTable').append(
                                 "<tr><td>"+value.name+"</td>"+
                                 "<td>"+value.amount+"</td>"+
                                 "<td>"+value.price+"</td></tr>"
                                 );
               })
                   
                    $('#modalBody').append("Total: " +totPrice.toFixed(2) + "$");
                    
                    $('#modalHeader').append('<br/><br/>');
                    
                    if (id != 1) {
                         $('#modalBody').append('<br/><br/><br/>');
                     $('#modalBody').append('Shipping details');
                       $('#modalBody').append("<form id='shippingForm' action='FinishPaymentServlet' method='POST'  role='form' class='form-horizontal'>"+
               "<div id='formContainer'>"+
                  "<label for='name'>Name:</label>"+
                  "<input type='text' name='name' value='"+name+"'  class='form-control' id='name'>"+
                   "<input type='hidden' name='id' value='"+id+"'  class='form-control' id='id'>"+
                 "<label for='surname'>Surname:</label>"+
                  "<input type='text' name='surname' value='"+surname+"'  class='form-control' id='surname'>"+
                 "<label for='shippingadress'>Shipping Adress:</label>"+
                  "<input type='text' name='shippingadress' value='"+adress+"' class='form-control' id='shippingAdress'>"+
                                  
                  "<div id='payment'>"+
                 "<label for='paymentOption'>Payment option:</label>&nbsp&nbsp"+
                  "<input type='radio' id='delivery' name='group' value='delivery' checked>"+
                 
                   " <label for='delivery'>On delivery</label>&nbsp&nbsp"+
                
                   " <input type='radio' id='payPal' name='group' value='payPal'>"+
                   " <label for='payPal'>pay Pal</label></div>"+
                  "<br/> <input type='submit' class='btn btn-primary' value='Pay'  id='btnAddToCart' > "+
                  
                  "</div> </form>");
                
            }
            else
            {
                 $('#modalBody').append('<br/><br/><br/>');
                     $('#modalBody').append('Shipping details');
                       $('#modalBody').append("<form id='shippingForm' action='FinishPaymentServlet' method='POST'  role='form' class='form-horizontal'>"+
               "<div id='formContainer'>"+
                  "<label for='name'>Name:</label>"+
                  "<input type='text' name='name' value='"+name+"'  class='form-control' id='name'>"+
                   "<input type='hidden' name='id' value='"+id+"'  class='form-control' id='id'>"+
                 "<label for='surname'>Surname:</label>"+
                  "<input type='text' name='surname' value='"+surname+"'  class='form-control' id='surname'>"+
                 "<label for='shippingadress'>Shipping Adress:</label>"+
                  "<input type='text' name='shippingadress' value='"+adress+"' class='form-control' id='shippingAdress'>"+
                                  
                  "<div id='payment'>"+
                 "<label for='paymentOption'>Payment option:</label>&nbsp&nbsp"+
                  "<input type='radio' id='delivery' name='group' value='delivery' checked>"+
                 
                   " <label for='delivery'>On delivery</label>&nbsp&nbsp"+
                  
                  "<br/> <input type='submit' class='btn btn-primary' value='Pay'  id='btnAddToCart' > "+
                  
                  "</div> </form>");
            }
                   
            
           
                   $('#myModal').modal('show');
     }
     
     });
 }
  

 