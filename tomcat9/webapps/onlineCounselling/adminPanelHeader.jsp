<!--header-->
<!-- # for id of element . for class of element selection then name of subelement to which we want to apply css  -->
<style type="text/css">
  #collapse-target ul li a
  {
    font-weight: bold;
    font-family: verdana;
    font-style: italic;
    color: white;

  }
 #collapse-target ul li a:hover
  {
    border-bottom: 2px solid red;
  }
  #collapse-target ul li a:active
  {
    background-color: white;
  }
  #collapse-target ul li
  {
  opacity: .9;
  color: black;
  }
  #collapse-target ul 
  {
    
  }

   .dropdown ul li
  {
    margin:15px;
  }
  .dropdown
  {
    margin:2px;
  }
</style>
<!--navbar-->
<nav class="navbar navbar-expand-sm  navbar-dark sticky-top" style="background-color: #4d1d7c;font-family: Montserrat, sans-serif;min-height: 80px;z-index: 9999;border-bottom: 1px solid black;font-size: 12px !important;letter-spacing: 2px;color: white">

  <button class="navbar-toggler" data-toggle="collapse" data-target="#collapse-target" >
    <!--this button is to make the below division whose id is collpase-target .as responsive ..span is a icon shown when screeen collapse -->
    <span class="navbar-toggler-icon">
    </span>
  </button>
  <div class="collapse navbar-collapse" id="collapse-target" style="margin-left: 30px">
    
<div style="margin-right: 50px;left:0">
  <h1>Admin Section</h1>
</div>

<div class="dropdown" >
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Add Information
 </button>
  <ul class="dropdown-menu" style="background-color: green;font-size: 12px;">
    <!--<li><a href="#">View Campuses</a></li>-->
      <li onclick="javascript:addCountryFunction('block')"><a href="#">Add Country</a></li>
      <li onclick="javascript:addStateFunction('block')"><a href="#">Add State</a></li>
      <li onclick="javascript:addCityFunction('block')"><a href="#">Add City</a></li>
    <li onclick="javascript:addCampusFunction('block')"><a href="#">Add Campus</a></li>
    <li onclick="javascript:addStreamFunction('block')"><a href="#">Add Stream</a></li>
    <li onclick="javascript:addBranchFunction('block')"><a href="#">Add Branch</a></li>
    <li onclick="javascript:addBranchSeatsFunction('block')"><a href="#">Add Branch Seats</a></li>

  </ul>
</div>



<!--
<div class="dropdown" >
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Stream
 </button>
  <ul class="dropdown-menu" style="background-color: green;font-size: 12px;">

    <li onclick="javascript:addStreamFunction('block')"><a href="#">Add Stream</a></li>
  </ul>
</div>

<div class="dropdown" >
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Branch
 </button>
  <ul class="dropdown-menu" style="background-color: green;font-size: 12px;">

    <li onclick="javascript:addBranchFunction('block')"><a href="#">Add Branch</a></li>
    <li onclick="javascript:addBranchSeatsFunction('block')"><a href="#">Add Branch Seats</a></li>
  </ul>
</div>

<div class="dropdown" >
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">City
 </button>
  <ul class="dropdown-menu" style="background-color: green;font-size: 12px;">
   
    <li onclick="javascript:addCityFunction('block')"><a href="#">Add City</a></li>
  </ul>
</div>

<div class="dropdown" >
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">State
 </button>
  <ul class="dropdown-menu" style="background-color: green;font-size: 12px;">
  
    <li onclick="javascript:addStateFunction('block')"><a href="#">Add State</a></li>
  </ul>
</div>

<div class="dropdown" >
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Country
 </button>
  <ul class="dropdown-menu" style="background-color: green;font-size: 12px;">
   <li><a href="#">View Countries</a></li>
    <li onclick="javascript:addCountryFunction('block')"><a href="#">Add Country</a></li>
  </ul>
</div>

-->

</div>

</nav>


<!--for search
<div id="aaabbb" style="display: none;background-color: black;z-index: 100001 !important;position: absolute;min-height: 500px" class="container col-sm-12">
<div id="searchDivision" class="container-fluid col-sm-7" style="background-color: #ed9393">
  
</div>
</div>
-->
<!--navbar-->
<!--header-->






<script>
  //add campus division display none or block
  function addCampusFunction(dsply)
  {  
    document.getElementById("addCampus").style.display=dsply;
    document.getElementById("addStream").style.display='none';
    document.getElementById("addBranch").style.display='none';
    document.getElementById("addCity").style.display='none';
    document.getElementById("addState").style.display='none';
    document.getElementById("addBranchSeats").style.display='none';
    document.getElementById("addCountry").style.display='none';
    clearAddCampusForm(); 
    getCountryList('addCampusFormCountryDropDown');
  }

  function addStreamFunction(dsply)
  {
    document.getElementById("addCampus").style.display='none';
    document.getElementById("addStream").style.display=dsply;
    document.getElementById("addBranch").style.display='none';
    document.getElementById("addCity").style.display='none';
    document.getElementById("addState").style.display='none';
    document.getElementById("addCountry").style.display='none';
    document.getElementById("addBranchSeats").style.display='none';
  }

  function addBranchFunction(dsply)
  {
    document.getElementById("addCampus").style.display='none';
    document.getElementById("addStream").style.display='none';
    document.getElementById("addBranch").style.display=dsply;
    document.getElementById("addBranchSeats").style.display='none';
    document.getElementById("addCity").style.display='none';
    document.getElementById("addState").style.display='none';
    document.getElementById("addCountry").style.display='none';
    getStreamList('addBranchFormStreamDropDown');
  }
  function addBranchSeatsFunction(dsply)
  {
    document.getElementById("addCampus").style.display='none';
    document.getElementById("addStream").style.display='none';
    document.getElementById("addBranchSeats").style.display=dsply;
    document.getElementById("addBranch").style.display='none';
    document.getElementById("addCity").style.display='none';
    document.getElementById("addState").style.display='none';
    document.getElementById("addCountry").style.display='none';
    getCampusList('addBranchSeatsFormCampusDropDown');
    getStreamList('addBranchSeatsFormStreamDropDown');
  }


  function addCityFunction(dsply)
  {
    document.getElementById("addCampus").style.display='none';
    document.getElementById("addStream").style.display='none';
    document.getElementById("addBranch").style.display='none';
    document.getElementById("addCity").style.display=dsply;
    document.getElementById("addBranchSeats").style.display='none';
    document.getElementById("addState").style.display='none';
    document.getElementById("addCountry").style.display='none';
    getCountryList('addCityFormCountryDropDown');
  }

  function addStateFunction(dsply)
  {
    document.getElementById("addCampus").style.display='none';
    document.getElementById("addStream").style.display='none';
    document.getElementById("addBranch").style.display='none';
    document.getElementById("addCity").style.display='none';
    document.getElementById("addState").style.display=dsply;
    document.getElementById("addBranchSeats").style.display='none';
    document.getElementById("addCountry").style.display='none';
    getCountryList('addStateFormCountryDropDown');//for adding data in country dropdown
  }

  function addCountryFunction(dsply)
  {
    document.getElementById("addCountry").style.display=dsply;
    document.getElementById("addBranchSeats").style.display='none';
    document.getElementById("addCampus").style.display='none';
    document.getElementById("addStream").style.display='none';
    document.getElementById("addBranch").style.display='none';
    document.getElementById("addCity").style.display='none';
    document.getElementById("addState").style.display='none';
  }
  
function clearAddCampusForm(formId)
{
  var d=document.getElementById('addCampusFormCountryDropDown');
  while(d.children[1]) 
  {
    d.removeChild(d.children[1]);
  }
  d=document.getElementById('addCampusFormStateDropDown');
  while(d.children[1]) 
  {
    d.removeChild(d.children[1]);
  }
  d=document.getElementById('addCampusFormCityDropDown');
  while(d.children[1]) 
  {
    d.removeChild(d.children[1]);
  }
}
</script>
