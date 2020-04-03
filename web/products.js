/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var initiated = false;

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
 
 var category=null;
 $(function() {
     
      var divName = document.getElementsByClassName('desc');
      var id= Cookies.get("user_id");

   $.each(divName, function(index, value) {
  console.log(value.innerText);
  
      $.ajax({url: "ProductsServlet",
      method:"GET",
     data:{"name":value.innerText},
     success: function(result){
         console.log(result);
         
       var category1= result.categoryId;
                switch (category1)
                {
                    case 1:category="categoryMasks.jsp";
                        break;
                    case 2:category="categoryInhalators.jsp";
                        break;
                    case 3:category="categoryPills.jsp";
                        break;
                    case 4:category="categoryGloves.jsp";
                        break;
                    case 5:category="categoryCures.jsp";
                        break;
                    case 6:category="categoryMedicalDevices.jsp";
                        break;
                    case 7:category="categoryCosmetics.jsp";
                        break;
                        default :category="allProducts.jsp";
                            break;
                        
                }
        
        if (result.name == 'Corona Virus Cure') {
                    
                     
            $(value).prepend ("<p id='cartInfo'>Price:5 iz Jave Web </p>");
             $(value).prepend (
                  " <form id='form1' action='CartServlet' method='POST'  role='form' class='form-horizontal'>"+
               "<div id='formContainer'>"+
                  "<label for='amount'>Amount:</label>"+
                  "<input type='number' name='amount'  class='form-control' id='amount'>"+
                  " <input type='hidden' id='userId' name='userId' value='"+id+"'>"+
                  " <input type='hidden' id='price' name='price' value='1'>"+
                  " <input type='hidden' id='category' name='category' value='"+category+"'>"+
                  " <input type='hidden' id='articleID' name='articleID' value='"+result.idArticle+"'>"+
                  "<br/> <input type='submit' class='btn btn-primary' value='Add to cart'  id='btnAddToCart' > "+
               "</div>"
                );
             }
                else{
         $(value).prepend ("<p id='cartInfo'>Price: "+result.price+"$</p>");
          $(value).prepend (
                  " <form id='form1' action='CartServlet' method='POST'  role='form' class='form-horizontal'>"+
               "<div id='formContainer'>"+
                  "<label for='amount'>Amount:</label>"+
                  "<input type='number' name='amount'  class='form-control' id='amount'>"+
                  " <input type='hidden' id='userId' name='userId' value='"+id+"'>"+
                  " <input type='hidden' id='price' name='price' value='"+result.price+"'>"+
                  " <input type='hidden' id='category' name='category' value='"+category+"'>"+
                  " <input type='hidden' id='articleID' name='articleID' value='"+result.idArticle+"'>"+
                  "<br/> <input type='submit' class='btn btn-primary' value='Add to cart'  id='btnAddToCart' > "+
               "</div>"
                );
    }
       
     }
     
     
 
 });
  
});

    

 });
 function getArticle()
 {
     document.getElementById("demo").innerHTML += index + ":" + item + "<br>";
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
function openModal(title,img_src)
{
    var description;
   
    
     $.ajax({url: "ProductsServlet",
      method:"GET",
     data:{"name":title},
     success: function(result){
        description = result.description;
         $('#modalHeader').append(title);
            var img = document.createElement("img");
            img.src = img_src;
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

