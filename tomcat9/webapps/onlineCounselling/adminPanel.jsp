<!DOCTYPE html>
<html>
<head>
	<title>admin panel</title>
	<jsp:include page="library.jsp" />
	<jsp:include page="adminPanelHeader.jsp" />
</head>
<script type="text/javascript">
	function addRow(tableID) {

			var table = document.getElementById(tableID);

			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);

			var colCount = table.rows[0].cells.length;

			for(var i=0; i<colCount; i++) {

				var newcell	= row.insertCell(i);

				newcell.innerHTML = table.rows[0].cells[i].innerHTML;
				//alert(newcell.childNodes);
				switch(newcell.childNodes[0].type) {
					case "text":
							newcell.childNodes[0].value = "";
							break;
					case "checkbox":
							newcell.childNodes[0].checked = false;
							break;
				}
			}
		}

		function deleteRow(tableID) {
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if(null != chkbox && true == chkbox.checked) {
					if(rowCount <= 1) {
						alert("Cannot delete all the rows.");
						break;
					}
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
			}catch(e) {
				alert(e);
			}
		}
	
</script>

<body>


<div id="addCampus" style="display: none;border:1px solid black;margin-top: 10px" class="col-sm-6 container">
	<form id="addCampusForm">
		<label><h3>Add Campus</h3></label><br>
		<center>
		<label>Name </label>
		<input type="text" name="campusName" ><br>
		<label>Address </label>
		<input type="text" name="address" ><br>
		<label>Country </label>
		<select name="country" id="addCampusFormCountryDropDown"  onchange ="javascript:getStateList(this.value,'addCampusFormStateDropDown')">
					<OPTION value=0>Select</OPTION>
			</select><br>
		<label>State </label>
		<select  name="state" id="addCampusFormStateDropDown"  onchange ="javascript:getCityList(this.value,'addCampusFormCityDropDown')">
					<OPTION value=0>Select</OPTION>
			</select><br>
		<label>City </label>
		<select name="city" id="addCampusFormCityDropDown">
					<OPTION value=0>Select</OPTION>
			</select><br>
		<label>Zip Code </label>
		<input type="text" name="zipCode" required=""><br><br>

		<button type="button" class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;"  onclick="javascript:addCampus('addCampusForm')">Add
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addStreamFunction('none')">Cancel
        </button>
        <input type="reset" name="" style="visibility: hidden" id="resetAddCampusForm">
        </center>
	</form>
</div>




<div id="addStream" style="display: none;border:1px solid black;margin-top: 10px" class="col-sm-6 container">
	<form>
		<label><h3>Add Stream</h3></label><br>
		<center>
		<input type="button" value="Add Row" onclick="addRow('addStreamTable')" />
		<input type="button" value="Delete Row" onclick="deleteRow('addStreamTable')" />
		<div>
			<table id="addStreamTable">
				<tr>
					<td><input type='checkbox' name='chk'/></td>
					<td><label>Stream </label></td>
					<td><input type='text' name='streamName'/></td>
					<td><label>Full Name </label></td>
					<td><input type="text" name="fullName"></td>
				</tr>
			</table>
		</div>
		<button type="button" class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;"  onclick="addStream('addStreamTable')">Add
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addStreamFunction('none')">Cancel
        </button>
         <input type="reset" name="" style="visibility: hidden" id="resetAddStreamForm">
        </center>
	</form>
</div>




<div id="addBranch" style="display:none;border:1px solid black;margin-top: 10px" class="col-sm-8 container">
	<form>
		<label><h3>Add Branch</h3></label><br>
		<center>
		<div>
			<label>Select Stream : </label>
			<select name="state" id="addBranchFormStreamDropDown">
					<OPTION value=0>Select</OPTION>
			</select><br><br>
			<input type="button" value="Add Row" onclick="addRow('addBranchTable')" />
			<input type="button" value="Delete Row" onclick="deleteRow('addBranchTable')" />
			<table id="addBranchTable">
				<tr>
					<td><input type='checkbox' name='chk'/></td>
					<td><label style="margin-left: 15px">Branch Name </label></td>
					<td><input type='text' name='branchName' /></td>
					<td><label style="margin-left: 25px">Full Name </label></td>
					<td><input type='text' name='fullName' /></td>
					

				</tr>
			</table>
		</div>
		<button type="button"  class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;" onclick="javascript:addBranch('addBranchTable','addBranchFormStreamDropDown')" >Add
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addBranchFunction('none')">Cancel
        </button>
         <input type="reset" name="" style="visibility: hidden" id="resetAddBranchForm">
        </center>

	</form>
</div>





<div id="addBranchSeats" style="display:none;border:1px solid black;margin-top: 10px" class="col-sm-8 container">
	<center>
	<form id="addBranchSeatsForm">
			<label><h3>Add Branch seats</h3></label><br>
			<label>Select Campus : </label>
			<select name="campus" id="addBranchSeatsFormCampusDropDown">
					<OPTION value=0>Select</OPTION>
					
			</select><br>
			<label>Select Stream : </label>
			<select name="stream" id="addBranchSeatsFormStreamDropDown" onchange="javascript:getBranchSeatsForm('addBranchSeatsTableBody',this.value)">
					<OPTION value=0>Select</OPTION>
					
			</select><br><br>
			<table  id="addBranchSeatsTable" border="1px solid black">
				<thead>
					<tr>
						<th><label style="margin-left: 15px">Branch Name </label></th>
						<th><label style="margin-left: 25px">Full Name </label></th>
						<th><label style="margin-left: 25px">No. of seats </label></th>
					</tr>
					
				</thead>
				<tbody id="addBranchSeatsTableBody" >

				</tbody>

			<!--add row by fecthing all the branch of stream and give a text box in front of each row to enter the number of seats in this form user enters only no. of seats while branch name is fecthed from database and shown in uneditable textbox-->
			</table>
		<button type="button" class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;" onclick="javascript:addBranchSeats('addBranchSeatsForm','addBranchSeatsTableBody')">Add
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addBranchSeatsFunction('none')">Cancel
        </button>
	</form>
    </center>
</div>




<div id="addCity" style="display:none;border:1px solid black;margin-top: 10px" class="col-sm-6 container">
	<form>
		<label><h3>Add City</h3></label><br>
		<center>
		<div>
			<label>Select Country : </label>
			<select name="country" id="addCityFormCountryDropDown" onchange ="javascript:getStateList(this.value,'addCityFormStateDropDown')">
					<OPTION value=0>Select</OPTION>
			</select><br>
			<label>Select State : </label>
			<select name="state" id="addCityFormStateDropDown">
					<OPTION value=0>Select</OPTION>
					
			</select><br><br>
			<input type="button" value="Add Row" onclick="addRow('addCityTable')" />
			<input type="button" value="Delete Row" onclick="deleteRow('addCityTable')" />
			<table id="addCityTable">
				<tr>
					<td><input type='checkbox' name='chk'/></td>
					<td><label>City Name </label></td>
					<td><input type='text' name='cityName'/></td>
				</tr>
			</table>
		</div>
		<button type="button" class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;"  onclick="javascript:addCity('addCityTable','addCityFormStateDropDown')">Add
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addCityFunction('none')">Cancel
        </button>
        <input type="reset" name="" style="visibility: hidden" id="resetAddCityForm">
        </center>
	</form>
</div>




<div id="addState" style="display:none;border:1px solid black;margin-top: 10px" class="col-sm-6 container">
	<form>
		<label><h3>Add State</h3></label><br>
		<center>
		<div>
			<label>Select Country : </label>
			<select name="country" id="addStateFormCountryDropDown">
					<OPTION value=0>Select</OPTION>
				
			</select><br><br>
			<input type="button" value="Add Row" onclick="addRow('addStateTable')" />
			<input type="button" value="Delete Row" onclick="deleteRow('addStateTable')" />
			<table id="addStateTable">
				<tr>
					<td><input type='checkbox' name='chk'/></td>
					<td><label>State Name </label></td>
					<td><input type='text' name='stateName'/></td>
				</tr>
			</table>
		</div>
		<button type="button" class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;"  onclick="javascript:addState('addStateTable','addStateFormCountryDropDown')">Add State
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addStateFunction('none')">Cancel
        </button>
        <input type="reset" name="" style="visibility: hidden" id="resetAddStateForm">
        </center>
	</form>
</div>




<div id="addCountry" style="display: none;border:1px solid black;margin-top: 10px" class="col-sm-6 container">
	<form>
		<label><h3>Add Country</h3></label><br>
		<center>
		<input type="button" value="Add Row" onclick="addRow('addCountryTable')" />
		<input type="button" value="Delete Row" onclick="deleteRow('addCountryTable')" />
		<div>
			<table id="addCountryTable">
				<tr>
					<td><input type='checkbox' name='chk'/></td>
					<td><label>Country Name </label></td>
					<td><input type='text' name='countryName'/></td>
				</tr>
			</table>
		</div>
		<button type="button" class="btn btn-primary" style="margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;" onclick="javascript:addCountry('addCountryTable')">Add Country
        </button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;" onclick="javascript:addCountryFunction('none')">Cancel
        </button>
         <input type="reset" name="" style="visibility: hidden" id="resetAddCountryForm">
        </center>
	</form>
</div>

</body>
</html>
