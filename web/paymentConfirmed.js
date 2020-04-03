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
           $.ajax({url: "CartServlet",
            method:"DELETE",
             data:{},
             success: function(result){
         console.log(result);
     }
 });
        $('#welcomeMsg').append(result.username);
        $('#settings').append('Settings');
        $('#signOut').append('<a href="mainScreen.jsp" id="signOut" onclick="resetCookie()">Sign off</a>');
        
    
        
      },
      error: function(){
              $.cookie("user_id", null);
                $.ajax({url: "CartServlet",
            method:"DELETE",
             data:{},
             success: function(result){
         console.log(result);
     }
 });
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

