$( document ).ready(function() {
     
	$("#putBtn").click(function(event){
        event.preventDefault();
        ajaxPut();
    });
	
    var url    = window.location;
     
    function ajaxPut(){
    	var nombre = $('#newName').val(); 

    	var formData = {
            firstname : $("#firstname").val(),
            lastname  :  $("#lastname").val(),
            trabajo   :  $("#trabajo").val()
        }

        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : url + "/putcustomer/"+nombre,
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
            	alert(result);
                if(result.status == "Done"){
                    $("#postResultDiv").html("<strong>" + "Info: FirstName = "
                            + result.data.firstname + " ,LastName = " + result.data.lastname + ", Trabajo: "+result.data.trabajo+"</strong>");
                }else if(result.status == "notFound"){
                	$("#postResultDiv").html("<strong>not Found: "+nombre+"</strong>");
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