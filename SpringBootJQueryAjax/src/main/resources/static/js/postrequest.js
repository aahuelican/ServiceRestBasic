$( document ).ready(function() {
     
    var url = window.location;
     
    $("#customerForm").submit(function(event) {
        event.preventDefault();
        ajaxPost();
    });
     
     
    function ajaxPost(){
         
        var formData = {
            firstname : $("#firstname").val(),
            lastname  :  $("#lastname").val(),
            trabajo   :  $("#trabajo").val()
        }

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : url + "/postcustomer",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
            	alert(result);
                if(result.status == "Done"){
                    $("#postResultDiv").html("<strong>" + "Info: FirstName = "
                            + result.data.firstname + " ,LastName = " + result.data.lastname + ", Trabajo: "+result.data.trabajo+"</strong>");
                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        resetData();
    }
     
    function resetData(){
        $("#firstname").val("");
        $("#lastname").val("");
    }
})