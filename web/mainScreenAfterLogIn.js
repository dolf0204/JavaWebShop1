var x= 1;
var formatedTime;
var minutes;
var month;     
$(function() {
    var id= Cookies.get("user_id");
    //console.log(id);
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

 $(document).ready(function() {
      $('#lightSlider').lightSlider({
        gallery: true,
        item: 1,
        loop: true,
        slideMargin: 0,
        thumbItem: 9
      });
      
      });

$(document).ready(function() {
   var platform = new H.service.Platform({
  'apikey': 'dmHBfoCjGZZu-87_5lFZXNRq9_KcoKAdREHcY7VSVvc'
  
  
}); 
var defaultLayers = platform.createDefaultLayers();

// Instantiate (and display) a map object:
var map = new H.Map(
    document.getElementById('mapContainer'),
    defaultLayers.vector.normal.map,
    {
      zoom: 17,
      center: { lat: 45.797180, lng: 15.935030 }
    });
    
    var mapEvents = new H.mapevents.MapEvents(map);

// Instantiate the default behavior, providing the mapEvents object:
new H.mapevents.Behavior(mapEvents);
});
