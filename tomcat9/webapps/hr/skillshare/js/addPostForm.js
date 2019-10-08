//function to preview image
    $(function(){
                $('#imageFile').change(function(e){
                  
                    var filePath = URL.createObjectURL(e.target.files[0]);
                    var fileName = e.target.files[0].name;
                    $('#postImage').attr('src',filePath);
                    $('#preview').show(1000);
                    var hideAddIcon=document.getElementById('addIcon');
                    hideAddIcon.style.display="none";
	 //$('#imageFile').val('');// clear previous value so if user select same image second time 
                                            //then change function works,otherwise it will not work
   
                   
                });
        
            });

    //function to clear previous value so if user select same image second time then change function works
   


 //function to cancel image upload
    $(function(){
                $('#cancelImageUpload').click(function(e){
                  $('#preview').hide(500);
                    $('#postImage').attr('src',"");
                    $('#imageFile').attr('value',null);
                    $('#imageFile').val('');//clear the file so nothing is go to server
                    var showAddIcon=document.getElementById('addIcon');
                    showAddIcon.style.display="inline";
                });
        
            });

//function to reset form
 function formReset()
    {
      document.getElementById('imageFile').value=null;
      $('#preview').hide();
      $('#addIcon').show();
      document.getElementById('title').value="";
      document.getElementById('heading').value="";
      document.getElementById('description').value="";

    }