<!--Add Post Modal-->
<div class="modal fade" id="myModal" style="background-color: black;z-index: 100001 !important;">
                                                      <!---if not z index then modal is seen behind the fix navbar-->
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add Post
        </h4>
        <button type="button" class="close" data-dismiss="modal" onclick="javascript:formReset()">&times;
        </button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        <form action="/skillshare/addThread" id="addPostForm" method="POST" enctype="multipart/form-data">
          <div class="form-group">
            <label for="imageFile" id="addIcon">Add Image
              <img src="images/add_icon.png" class="addIcon">
            </label> 
            <!-- image preview division -->
            <div id="preview" class="form-control" style="display:none;height:auto;text-align: center">
              <input type="file" name="imageFile" id="imageFile" style="display: none" (click)="fileInput.value = null" multiple>
              <img src="" id="postImage" class="postImage rounded img-fluid" style="width: 15rem;height: 15rem">
              <br>
              <label  for="imageFile" style="font-size: 20px;color: green;cursor: pointer;">Change
              </label>
              <label id="cancelImageUpload" style="font-size: 20px;color: red;cursor: pointer;">Cancel
              </label>
            </div>
            <br>
            <label for="topic">Topic:
            </label>
            <input type="text" name="topic" id="topic" class="form-control" required="">
            <label for="heading">Heading:
            </label>
            <input type="text" name="heading" id="heading" class="form-control" required="">
            <!--later it may be heading1 heading2 heading3 and so on description1 description2  we check all in request in servlet and make separate table to store them all three subpart (img heading dscription)  main table consist of (postId userID Title)-->
            <label for="content">Description:
            </label>
            <textarea class="form-control" rows="5" id="content" name="content" style="resize: none;" required="">
            </textarea>
            <label for="link">Add Link:
            </label>
            <input type="text" name="link" id="link" class="form-control" >
            <button type="submit" class="btn btn-primary form-control" style="border-radius: 100px;margin-top: 15px;letter-spacing: 1px">Add Post
            </button>
            <button type="button" class="btn btn-secondary form-control" data-dismiss="modal" style="border-radius: 100px;margin-top: 10px;letter-spacing: 1px">Cancel
            </button>
          </div>
        </form>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
<!--modal ends-->
