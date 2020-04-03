/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    var id= Cookies.get("user_id");
  var loginFields=document.getElementById('logInFields');
    if (id != null)
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
  }
  else{
    //window.open("mainScreen.jsp", "_self");
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
     var id= Cookies.get("user_id");
     
        $.ajax({url: "UserHistoryServlet",       
    method:"GET",
     data:{"userId":id},
     success: function(result){
         console.log(result);
         $.each(result, function(index, value) {
             
                if (value.shoppingDate.time.minute.toString().length == 1) {
                  var formatedMinutes   = "0"+ value.shoppingDate.time.minute.toString();
                }
                else
                {
                    var formatedMinutes   = value.shoppingDate.time.minute.toString();
                }
             
          $('#dates').append($("<option />").val(value.idCart).text(value.shoppingDate.date.day+"/"+
                  value.shoppingDate.date.month+"/"+value.shoppingDate.date.year+"-"+value.shoppingDate.time.hour+
                  ":"+  formatedMinutes ));
            
         });
        
     }
 });

});
function getCartItems(value)
{
    
     $.ajax({url: "UserHistoryServlet",
    method:"POST",
     data:{"singleCartId":value},
     success: function(result){
        $("#myTable tbody tr").remove();
        var totalPrajs;
        $.each(result, function(index, value) {
           totalPrajs= value.totalPrice; 
            $('#myTable').append("<tr><td>"+value.name+"</td><td>"+value.amount+"</td>"+
                    "<td>"+value.price+" $</td></tr>");
                    
        });
        $('#myTable').append("<tr><td>Total: "+totalPrajs+" $</td></tr>");
        
     }
 });
}
