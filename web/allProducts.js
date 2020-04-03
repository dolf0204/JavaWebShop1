/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var initiated = false;
$(function() {
     var loginFields=document.getElementById('logInFields');
    var id= Cookies.get("user_id");
    //console.log(id);
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
 
 $(function() {
     
      var divName = document.getElementById('MainScreenMiddleSection');
       var id= Cookies.get("user_id");
//   $.each(divName, function(index, value) {
//  console.log(value.innerText);
  
      $.ajax({url: "AllProductsServlet",
      method:"GET",
     data:{},
     success: function(result){
     console.log(result);
     
      $.each(result, function(index, value) {
          
          if (value.name == 'Corona Virus Cure') {
                
                $(divName).prepend(" <div class='responsive' >"+
                "<div class='gallery'>"+
                    "<img src=Pictures/"+value.picturePath+" id='images' width='600' height='400'>"+
                  "<div class='desc'><p id='cartInfo'>Price: 5 iz Jave web</p>"+
                   " <form id='form1' action='CartServlet' method='POST'  role='form' class='form-horizontal'>"+
               "<div id='formContainer'>"+
                  "<label for='Amount'>Amount:</label>"+
                  "<input type='number' name='amount'  class='form-control' id='amount'>"+
                    " <input type='hidden' id='userId' name='userId' value='"+id+"'>"+
                  " <input type='hidden' id='price' name='price' value='1'>"+
                  " <input type='hidden' id='articleID' name='articleID' value='"+value.idArticle+"'>"+
                  "<br/> <input type='submit' class='btn btn-primary' value='Add to cart'  id='btnAddToCart' > "+
                   "<br/><br/><p id='name'>"+value.name+"</p></div>"+
                  "</div> </div>");
                 
           

           }
                      else{
               
                    $(divName).prepend(" <div class='responsive'>"+
                "<div class='gallery'>"+
                  
                    "<img src=Pictures/"+value.picturePath+" id='images' width='600' height='400'>"+
                  " <div class='desc'><p id='cartInfo'>Price: "+value.price+"$</p>"+
                   " <form id='form1' action='CartServlet' method='POST'  role='form' class='form-horizontal'>"+
               "<div id='formContainer'>"+
                  "<label for='Amount'>Amount:</label>"+
                  "<input type='number' name='amount'  class='form-control' id='amount'>"+
                  " <input type='hidden' id='userId' name='userId' value='"+id+"'>"+
                  " <input type='hidden' id='price' name='price' value='"+value.price+"'>"+
                  " <input type='hidden' id='articleID' name='articleID' value='"+value.idArticle+"'>"+
                  "<br/> <input type='submit' class='btn btn-primary' value='Add to cart'  id='btnAddToCart' > "+
                   "<br/><br/><p id='name'>"+value.name+"</p></div>"+
                  "</div> </div>");
                 

             
           

           }
    })
     }
          
      })
  })
        
             

 function getArticle()
 {
     document.getElementById("demo").innerHTML += index + ":" + item + "<br>";
 }

 $(document).on('click', '#images' , function() {
    var name =  $(this).parent().find('#name');
    var innerName = name[0].innerText;
     openModal(innerName);
    
});
 


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
function openModal(name)
{
    var description;
   
    
     $.ajax({url: "ProductsServlet",
      method:"GET",
     data:{"name":name},
     success: function(result){
        description = result.description;
         $('#modalHeader').append(result.name);
            var img = document.createElement("img");
            img.src ="Pictures/"+ result.picturePath;
            $(img).css("max-width", "20vw");
            $('#modalBody').append(img);
            $('#modalBody').append('<br/>');
            $('#modalBody').append(description);

            $('#myModal').modal('toggle');
     }
 });
  
        
  
    
           
}

function closeModal(site)
{
   
    window.open(site,"_self");
    $('#myModal').modal('close');
    
}


