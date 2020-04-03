/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    
        $.ajax({
        url : 'RegistrationConfirmedServlet', // or whatever
        dataType : 'json',
        method:"GET",
        
        success : function (result) {
           
          
                        

            $('#helloUser').append(" "+result);
            
           
        },
        error: function (result) {
        alert("error");
        }
        
});
});

