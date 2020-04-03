/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 var users=[];
$(function() {
    var id= Cookies.get("user_id");
    //console.log(id);
   
    if (id != null)
    {
    $.ajax({url: "MainScreenAfterLogInServlet",
    method:"GET",
     data:{"id":id},
     success: function(result){
       
       
        $('#welcomeMsg').append(result.username);
        $('#settings').append('Settings');
        $('#signOut').append('<a href="mainScreen.jsp" id="signOut" onclick="resetCookie()">Sign off</a>');
        
    
        
      },
      error: function(){
      
    }
      
      
    });
  }
  else{
    //window.open("mainScreen.jsp", "_self");
   console.log("Wrong");

}
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

   var list = new Array();
    var pageList = new Array();
    var currentPage = 1;
    var numberPerPage = 10;
    var numberOfPages = 0;
    var init = false;
//$(function() {
 function makeList()
    {
     $("#next").css('visibility','visible');
    $("#previous").css('visibility','visible');
    $("#first").css('visibility','visible');
    $("#last").css('visibility','visible');
          $.ajax({url: "AdminGetAnonymousUserServlet",
    method:"GET",
     data:{},
     success: function(result){
        // console.log(result);
        list = result;
        numberOfPages = getNumberOfPages();
            loadList();
             
     }
 });
}
function getNumberOfPages() {
    return Math.ceil(list.length / numberPerPage);
}
function nextPage() {
    currentPage += 1;
    loadList();
}

function previousPage() {
    currentPage -= 1;
    loadList();
}
function firstPage() {
    currentPage = 1;
    loadList();
}

function lastPage() {
    currentPage = numberOfPages;
    loadList();
}
function loadList() {
    var begin = ((currentPage - 1) * numberPerPage);
    var end = begin + numberPerPage;

    pageList = list.slice(begin, end);
    drawList();
    check();
}
function drawList() {
       $('#myTable tbody tr').remove();
    for (r = 0; r < pageList.length; r++) {
        
        if (pageList[r].date.time.minute.toString().length == 1) {
                  var formatedMinutes   = "0"+ pageList[r].date.time.minute.toString();
                }
                else
                {
                    var formatedMinutes   = pageList[r].date.time.minute.toString();
                }
              
                $('#myTable').append("<tr><td>"+pageList[r].username+"</td>"+
                        "<td>"+pageList[r].date.date.day+"-"+pageList[r].date.date.month+"-"+pageList[r].date.date.year+" "+pageList[r].date.time.hour+":"+formatedMinutes +"</td>"+
                        "<td>"+pageList[r].totalPrice.toFixed(2)+" $</td><td>"+pageList[r].paymentMethod+"</td><td><a id='showDetails' onClick='showDetails("+pageList[r].idCart+")'>Show</a></td>"
                        );
    }
   
}
function setUsers()
{
    load();
}
function check() {
    document.getElementById("next").disabled = currentPage == numberOfPages ? true : false;
    document.getElementById("previous").disabled = currentPage == 1 ? true : false;
    document.getElementById("first").disabled = currentPage == 1 ? true : false;
    document.getElementById("last").disabled = currentPage == numberOfPages ? true : false;
}

function load() {
    
    makeList();
  
}
    
window.onload = load;
function showDetails(id) {
    
        $.ajax({url: "AdminShoppingHistoryServlet",
    method:"POST",
    target: '#myModal',
     data:{"id":id},
     success: function(result){
        // console.log(result);
        var totPrice = result[0].totalPrice;
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
                     $('#myModal').modal('show');
                    
     }
 });
    
}
 function closeModal()
{
   
    window.open("adminNotAuthenticatedUserShoppingHistory.jsp","_self");
    $('#myModal').modal('close');
    
}
function setSingleUser()
{
           $("#next").css('visibility','hidden');
    $("#previous").css('visibility','hidden');
    $("#first").css('visibility','hidden');
    $("#last").css('visibility','hidden');
     $('#myTable tbody tr').remove();
    var input = document.getElementById("myInput");
    var inputText = input.value;
           $.ajax({url: "AdminGetAnonymousUserServlet",
    method:"POST",
     data:{"user":inputText},
     success: function(result){
        // console.log(result);
        
          $.each(result, function(index, value) {
             
                if (value.date.time.minute.toString().length == 1) {
                  var formatedMinutes   = "0"+ value.date.time.minute.toString();
                }
                else
                {
                    var formatedMinutes   = value.date.time.minute.toString();
                }
             
           $('#myTable').append("<tr><td>"+value.username+"</td>"+
                        "<td>"+value.date.date.day+"-"+value.date.date.month+"-"+value.date.date.year+" "+value.date.time.hour+":"+formatedMinutes +"</td>"+
                        "<td>"+value.totalPrice.toFixed(2)+" $</td><td>"+value.paymentMethod+"</td><td><a id='showDetails' onClick='showDetails("+value.idCart+")'>Show</a></td>"
                        );
            
         });
             
     }
 });
    
}
$(function () {
            $('#datetimepicker1').datepicker();
  });
  var date;
  function getDate()
  {
      date = $('#datetimepicker1').datepicker('getUTCDate');
      var year = date.getFullYear();
      var month = date.getMonth()+1;
      var day = date.getDate();
              
      console.log(year);
      console.log(month);
      console.log(day);
      
           $.ajax({url: "AdminGetShoppingsForDateServlet",
    method:"POST",
     data:{"year":year,"month":month,"day":day},
     success: function(result){
         //console.log(result);
            list = result;
        numberOfPages = getNumberOfPages();
            loadList();
     }
 });
  }



