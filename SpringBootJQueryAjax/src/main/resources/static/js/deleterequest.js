$( document ).ready(function() {
     
    var url = window.location;//http://localhost:8888/
     
    $("#deleteBtn").click(function(event){
        event.preventDefault();
        ajaxDelete();
    });

    function ajaxDelete(){
    	var nombre = $('#newName').val(); 
        $.ajax({
            type    : "DELETE",
            url     : url + "/deletecustomer/"+nombre,
            success : function(result){
                if(result.status == "Done"){
                	$("#postResultDiv").html("<strong>Eliminado: "+result.data.firstname+"</strong>");
                }else if(result.status == "notFound"){
                	$("#postResultDiv").html("<strong>No encontrado</strong>");
                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#postResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
})