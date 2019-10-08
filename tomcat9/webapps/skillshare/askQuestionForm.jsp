<!--Add Post Modal-->
<div class="modal fade" id="askQuestionModal" style="background-color: black;z-index: 100001 !important;">
                                                      <!---if not z index then modal is seen behind the fix navbar-->
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Ask Question
        </h4>
        <button type="button" class="close" data-dismiss="modal" onclick="javascript:formReset()">&times;
        </button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        <form action="/skillshare/addThread" id="addPostForm" method="POST" enctype="multipart/form-data">
          <div class="form-group">
            
            <br>
            <label for="topic">Topic:
            </label>
            <input type="text" name="topic" id="topic" class="form-control">
            <!--later it may be heading1 heading2 heading3 and so on description1 description2  we check all in request in servlet and make separate table to store them all three subpart (img heading dscription)  main table consist of (postId userID Title)-->
            <label for="question">Question:
            </label>
            <textarea class="form-control" rows="5" id="question" name="question" style="resize: none;">
            </textarea>
            
            <button type="submit" class="btn btn-primary form-control" style="border-radius: 100px;margin-top: 15px;letter-spacing: 1px">Ask Question
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
