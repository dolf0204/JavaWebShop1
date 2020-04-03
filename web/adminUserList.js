

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
$(function() {
    
        $.ajax({url: "AdminGetUserServlet",
    method:"GET",
     data:{},
     success: function(result){
       
            $.each(result, function(index, value) {
                users.push(value.username);
            });
            initiateAutoComplete();
     }
 });
    
});

function initiateAutoComplete(){
    autocomplete(document.getElementById("myInput"), users);
}

function autocomplete(inp, arr) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);
      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
              b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
      x[i].parentNode.removeChild(x[i]);
    }
  }
}
/*execute a function when someone clicks in the document:*/
document.addEventListener("click", function (e) {
    closeAllLists(e.target);
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
          $.ajax({url: "AdminGetUserServlet",
    method:"GET",
     data:{},
     success: function(result){
        // console.log(result);
        list = result;
        for( var i = 0; i < list.length; i++){ if ( list[i].idAuthenticatedUser === 1) { list.splice(i, 1); }}
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
        
       
              
    $('#myTable').append("<tr><td>"+pageList[r].username+"</td>"+
            "<td>"+pageList[r].name+"</td><td>"+pageList[r].surname+"</td><td>"+pageList[r].phone+"</td>"+
            "<td>"+pageList[r].email+"</td><td>"+pageList[r].adress+"</td>"
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

function setSingleUser()
{
           $("#next").css('visibility','hidden');
    $("#previous").css('visibility','hidden');
    $("#first").css('visibility','hidden');
    $("#last").css('visibility','hidden');
     $('#myTable tbody tr').remove();
    var input = document.getElementById("myInput");
    var inputText = input.value;
           $.ajax({url: "AdminGetUserInfoServlet",
    method:"GET",
     data:{"user":inputText},
     success: function(result){
        // console.log(result);
        
        
             
             $('#myTable').append("<tr><td>"+result.username+"</td>"+
            "<td>"+result.name+"</td><td>"+result.surname+"</td><td>"+result.phone+"</td>"+
            "<td>"+result.email+"</td><td>"+result.adress+"</td>"
         
            
         );
             
     }
 });
    
}

