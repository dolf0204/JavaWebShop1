/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//$(function () {
//    $('#form1')
//    .submit(function(e){
//
//        //e.preventDefault();
//        $.ajax({
//        url : 'registrationServlet', // or whatever
//        dataType : 'json',
//        method:"POST",
//        
//        data:$('#form1').serialize(),
//        success : function (result) {
//           
//          
//          alert(result);
//            
//           
//        },
//        error: function (result) {
//       // alert("error");
//        }
//        
//});
//});
//});

$(function () {
    $('#form1')
    .submit(function(e){

        e.preventDefault();
        $.ajax({
        url : 'registrationServlet', // or whatever
        dataType : 'json',
        method:"POST",
        target: '#myModal', 
        data:$('#form1').serialize(),
        success : function (result) {
           
          
            
            
            $('#modalHeader').append('Sucesefull');
            $('#modalBody').append(result+', you have succesefully registered, please proceed to log in');

            $('#myModal').modal('show');
        },
        error: function (result) {
            
            $('#modalHeader').append('Error');
            $('#modalBody').append("Username already exists");

            $('#myModal').modal('show');
           
        }
        
})
})
});


function closeModal()
{
   
    window.open("registration.jsp","_self");
    $('#myModal').modal('close');
    
}

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