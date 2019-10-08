<!--Add Post Modal-->
<div class="modal fade" id="signInModal" style="background-color: black;z-index: 100001 !important;">
                                                      <!---if not z index then modal is seen behind the fix navbar-->
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        
        <h4 class="modal-title" style="color: ">Sign In
        </h4>

        <button type="button" class="close" data-dismiss="modal" onclick="javascript:formReset()">&times;
        </button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        <form action="login" id="addPostForm" method="post">
          <div class="form-group">
            <input type="text" name="userName" id="userName" class="form-control" placeholder="Username" style="margin-top: 15px">
            <input type="password" name="passWord" id="passWord" class="form-control" placeholder="Password" style="margin-top: 15px">
           <button type="submit" class="btn form-control" style="border-radius: 100px;margin-top: 15px;letter-spacing: 1px ;background-color:  #11ba0b">LogIn
            </button>
            <button type="button" class="btn btn-secondary form-control" data-dismiss="modal" style="border-radius: 100px;margin-top: 10px;letter-spacing: 1px;background-color:  #f4112b">Cancel
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
