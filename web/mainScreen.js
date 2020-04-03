/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function makeACall(logInUsrName,logInPass) { 
    $.ajax({url: "LogInUserServlet",
    method:"POST",
    data:{"username":logInUsrName,"password":logInPass},
     success: function(result){
       
        $.cookie("user_id", result);
    
            if (result == 47) {
                window.open("adminMainScreenAfterLogIn.jsp","_self");
                
            }
            else
            {
             window.open("mainScreenAfterLogin.jsp","_self");

            }
      },
      error: function(){
        alert("Wrong username or password");
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
      