
//we have to create two functions for each form 
//1.clearForm(formId);
//verfyForm(formId);
function Country(vCode,vName)
{
	this.code=vCode;
	this.name=vName;
}
function State(vCode,vName,vCountryCode)
{
	this.code=vCode;
	this.name=vName;
	this.countryCode=vCountryCode;
}
function City(vCode,vName,vStateCode)
{
	this.code=vCode;
	this.name=vName;
	this.stateCode=vStateCode;
}
function Campus(vCode,vName,vAddress,vCityCode,vZipCode)
{
	this.code=vCode;
	this.name=vName;
	this.address=vAddress;
	this.cityCode=vCityCode;
	this.zipCode=vZipCode;
}
function Stream(vCode,vName,vFullName)
{
	this.code=vCode;
	this.name=vName;
	this.fullName=vFullName;
}
function Branch(vCode,vName,vFullName,vStreamCode)
{
	this.code=vCode;
	this.name=vName;
	this.fullName=vFullName;
	//this.noOfSeats=vNoOfSeats;
	//this.campusCode=vCampusCode;
	this.streamCode=vStreamCode;
}
function BranchSeats(vCampusCode,vStreamCode,vBranchCode,vSeats)
{
	this.campusCode=vCampusCode;
	this.streamCode=vStreamCode;
	this.branchCode=vBranchCode;
	this.seats=vSeats;
}

function CouncellingCentre()
{
	this.code=vCode;
	this.name=vName;
	this.address=vAddress;
	this.cityCode=vCityCode;
	this.zipCode=vZipCode;
	this.capacity=vCapacity;
}





function AdminService()
{
	this.addCountry=function(countries,successCallBack,exceptionCallBack,errorCallBack){
		var countryJSON={
			"countries":countries
			//jo name double quote me yaha diya h vahi udahr class ki property me hona chahiye jisme hum parse kaar rahe he.
			//list<CountryDTO>  countries; in CountryRequest.java
		};
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addCountry",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(countryJSON));
	}


    this.addState=function(states,successCallBack,exceptionCallBack,errorCallBack){
		var stateJSON={
			"states":states
		};
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addState",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(stateJSON));
	}


	this.addCity=function(cities,successCallBack,exceptionCallBack,errorCallBack){
		var cityJSON={
			"cities":cities
		};
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addCity",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(cityJSON));
	}



this.addCampus=function(campus,successCallBack,exceptionCallBack,errorCallBack){
		var campusJSON={
			"code":campus.code,
			"name":campus.name,
			"address":campus.address,
			"cityCode":campus.cityCode,
			"zipCode":campus.zipCode
		};
		//alert("code  "+campus.code+" name "+campus.name+" address "+campus.address+" cityCode "+campus.cityCode+" zipCode "+campus.zipCode);
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addCampus",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(campusJSON));
	}


	this.addStream=function(streams,successCallBack,exceptionCallBack,errorCallBack){
		var streamJSON={
			"streams":streams
		};
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addStream",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(streamJSON));
	}


	this.addBranch=function(branches,successCallBack,exceptionCallBack,errorCallBack){
		var branchJSON={
			"branches":branches
		};
		//alert(branches[0].streamCode+"  ghjkl");
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addBranch",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(branchJSON));
	}

this.addBranchSeats=function(branchSeats,successCallBack,exceptionCallBack,errorCallBack){
		var branchSeatsJSON={
			"branchSeats":branchSeats
		};
		//alert(branches[0].streamCode+"  ghjkl");

		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);
					if(applicationResponse.isError)
					{
						//alert(applicationResponse.error);
						errorCallBack(applicationResponse.error);
						return;
					}
					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					if(applicationResponse.isException)
					{ 
						exceptionCallBack(applicationResponse.exceptions);
					}
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addBranchSeats",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(branchSeatsJSON));
	}


this.addDayAndSlots=function(day,slot,days,slots){
		var addDayAndSlotsJSON={
			"day":day,
			"slot":slot,
			"days":days,
			"slots":slots
		};
		//alert(branches[0].streamCode+"  ghjkl");

		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					alert("Added successfully");
				}
				else
					errorCallBack(this.statusText);//this is for any other error 
			}
		};
		httpRequest.open("POST","addDayAndSlots",true);
		httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
		httpRequest.send(JSON.stringify(addDayAndSlotsJSON));
	}






	this.loadCountryData=function(successCallBack)
	{
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);

					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
						
					}
					else
						alert("unable to load country data");

				}
				else
					alert("unable to load country data due to some error : "+this.statusText);
			}
		};
		httpRequest.open("GET","getCountry",true);
		httpRequest.send();
	}
	this.loadStateData=function(successCallBack)
	{
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);

					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
						
					}
					else
						alert("unable to load state data");

				}
				else
					alert("unable to load state data due to some error : "+this.statusText);
			}
		};
		httpRequest.open("GET","getState",true);
		httpRequest.send();
	}
	this.loadCityData=function(successCallBack)
	{
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);

					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
						
					}
					else
						alert("unable to load city data");

				}
				else
					alert("unable to load city data due to some error : "+this.statusText);
			}
		};
		httpRequest.open("GET","getCity",true);
		httpRequest.send();
	}
	this.loadCampusData=function(successCallBack)
	{
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);

					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
					}
					else
						alert("unable to load campus data");

				}
				else
					alert("unable to load campus data due to some error : "+this.statusText);
			}
		};
		httpRequest.open("GET","getCampus",true);
		httpRequest.send();
	}


	this.loadStreamData=function(successCallBack)
	{
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);

					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
						
					}
					else
						alert("unable to load stream data");

				}
				else
					alert("unable to load stream data due to some error : "+this.statusText);
			}
		};
		httpRequest.open("GET","getStream",true);
		httpRequest.send();
	}


	this.loadBranchData=function(successCallBack)
	{
		var httpRequest=new XMLHttpRequest();
		httpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var applicationResponse=JSON.parse(httpRequest.responseText);

					if(applicationResponse.isSuccess)
					{
						successCallBack(applicationResponse.result);
						
					}
					else
						alert("unable to load branch data");

				}
				else
					alert("unable to load branch data due to some error : "+this.statusText);
			}
		};
		httpRequest.open("GET","getBranch",true);
		httpRequest.send();
	}
	

}//class admin service ends




















function AdminController()
{
	var service = new AdminService();
	var model = new AdminModel();
	var view = new AdminView();
	//controller wala service ki methods ko call krke successcallback hua to   model k data structure  ko update karke
	// view ki updateView ko call karega ...view ki updateView model se data uthha k div me show karwa dega 
	//error callback pr suresh ki errorcallback ko vo aane wali error forword kar dega
	//exception callback pr bhi esa hi hoga

	this.addCountry = function(countries,successCallBack,exceptionCallBack){
		service.addCountry(countries,function(countries){
			model.addCountry(countries);
			//model me add krke successcallback kiya
			successCallBack(countries);
			//view.updateCountryView(model);
		},function(exceptions){
			exceptionCallBack(exceptions);
		},function(error){
			//error hua to service wala hi dikha dega view wale ki showErrorPage call krke
			//so controller  ki add ko koi errorcallback ka address nhi chahiye
			//error ka kaam controller k hath me
			//exception and succes ka kaam ramesh k hath me
			//controller success pr model ko update karega
			//ramesh ki successcallback me model se data utha k  dikhane ka kaam karo
			//ya fir view me data dikhane wale functions likho and unko controller me call kr lo
			alert("unable to perform add country operation due to "+error);
			view.showErrorPage();
		});
	}


	this.addState = function(states,successCallBack,exceptionCallBack){
		service.addState(states,function(states){
			model.addState(states);
			//model me add krke successcallback kiya
			successCallBack(states);
			view.updateStateView(model);
		},function(exceptions){
			exceptionCallBack(exceptions);
		},function(error){
			alert("unable to perform add state operation due to "+error);
			view.showErrorPage(error);
		});
	}



	this.addCity = function(cities,successCallBack,exceptionCallBack){
		service.addCity(cities,function(cities){
			model.addCity(cities);
			//model me add krke successcallback kiya
			successCallBack(cities);
			view.updateCityView(model);
		},function(exceptions){
			exceptionCallBack(exceptions);
		},function(error){
			alert("unable to perform add state operation due to "+error);
			view.showErrorPage(error);
		});
	}

	this.addCampus = function(campus,successCallBack,exceptionCallBack){
		service.addCampus(campus,function(campus){
			model.addCampus(campus);
			//model me add krke successcallback kiya
			successCallBack(campus);
			//view.updateCampusView(campus);
		},function(exception){
			exceptionCallBack(exception);
		},function(error){
			alert("unable to perform add state operation due to "+error);
			view.showErrorPage(error);
		});
	}

	this.addStream = function(streams,successCallBack,exceptionCallBack){
		service.addStream(streams,function(streams){
			model.addStream(streams);
			//model me add krke successcallback kiya
			successCallBack(streams);
			//view.updateStreamView(model);
		},function(exceptions){
			exceptionCallBack(exceptions);
		},function(error){
			alert("unable to perform add stream operation due to "+error);
			view.showErrorPage(error);
		});
	}


		this.addBranch= function(branches,successCallBack,exceptionCallBack){
		service.addBranch(branches,function(branches){
			model.addBranch(branches);
			//model me add krke successcallback kiya
			successCallBack(branches);
			//view.updateStreamView(model);
		},function(exceptions){
			exceptionCallBack(exceptions);
		},function(error){
			alert("unable to perform add stream operation due to "+error);
			view.showErrorPage(error);
		});
	}
	this.addBranchSeats= function(branchSeats,successCallBack,exceptionCallBack){
		service.addBranchSeats(branchSeats,function(msg){
			//model.addBranch(branches);
			//model me add krke successcallback kiya
			successCallBack(msg);
			//view.updateStreamView(model);
		},function(exceptions){
			exceptionCallBack(exceptions);
		},function(error){
			alert("unable to perform add seats operation due to "+error);
			view.showErrorPage(error);
		});
	}

	this.addDayAndSlots=function(day,slot,days,slots)
	{
		service.addDayAndSlots(day,slot,days,slots);
	}


	


	this.loadData=function()
	{
		service.loadCountryData(function(data){
			//code to fill the model
			var l=data.length;
			var i=0;
			while(i<l)
			{
				model.countries.push(new Country(data[i].code,data[i].name));
				i++;
			}
		});
		service.loadStateData(function(data){
			//code to fill the model
			var l=data.length;
			var i=0;
			while(i<l)
			{
				model.states.push(new State(data[i].code,data[i].name,data[i].countryCode));
				i++;
			}
		});
		service.loadCityData(function(data){
			//code to fill the model
			var l=data.length;
			var i=0;
			while(i<l)
			{
				model.cities.push(new City(data[i].code,data[i].name,data[i].stateCode));
				i++;
			}
		});
		service.loadCampusData(function(data){
			//code to fill the model
			var l=data.length;
			var i=0;
			while(i<l)
			{
				model.campuses.push(new Campus(data[i].code,data[i].name,data[i].address,data[i].cityCode,data[i].zipCode));
			i++;
			}
		});
		service.loadStreamData(function(data){
			//code to fill the model
			var l=data.length;
			var i=0;
			while(i<l)
			{
				model.streams.push(new Stream(data[i].code,data[i].name,data[i].fullName));
			i++;
			}
		});
		service.loadBranchData(function(data){
			//code to fill the model
			var l=data.length;
			var i=0;
			while(i<l)
			{
				model.branches.push(new Branch(data[i].code,data[i].name,data[i].fullName,data[i].streamCode));
			i++;
			}
		});

		view.updateView(model);
	}
	












	this.getCountryList=function(successcallback)
	{
		successcallback(model.countries);
	}
	this.getStateList=function(countryCode,successCallBack)
	{
		states=[];
		var i=0;
		var l=model.states.length;
		while(i<l)
		{
			if (model.states[i].countryCode==countryCode) {states.push(model.states[i])}
				i++;
		}
	successCallBack(states);	
	}
	this.getCityList=function(stateCode,successCallBack)
	{
		cities=[];
		var i=0;
		var l=model.cities.length;
		while(i<l)
		{
			if (model.cities[i].stateCode==stateCode) {cities.push(model.cities[i])}
				i++;
		}
	successCallBack(cities);	
	}
	this.getStreamList=function(successcallback)
	{
		successcallback(model.streams);
	}
	this.getCampusList=function(successcallback)
	{
		successcallback(model.campuses);
	}
	this.getBranchList=function(streamCode,successCallBack)
	{
		branches=[];
		var i=0;
		var l=model.branches.length;
		while(i<l)
		{
			if (model.branches[i].streamCode==streamCode) {branches.push(model.branches[i])}
				i++;
		}
	successCallBack(branches);	
	}

}
































function AdminModel()
{
	this.countries=[];
	this.states=[];
	this.cities=[];
	this.campuses=[];
	this.streams=[];
	this.branches=[];
	this.councellingCentres=[];

	this.addCountry=function(countryArray){
		//our code for  multiple entries
		var l=countryArray.length;
		for(var i=0;i<l;i++)
		//our code for multiple entries
		this.countries.push(new Country(countryArray[i].code,countryArray[i].name));
		//alert("country added sucessfully!");
	}
	this.addState=function(stateArray){
		var l=stateArray.length;
		for(var i=0;i<l;i++)
		this.states.push(new State(stateArray[i].code,stateArray[i].name,stateArray[i].countryCode));
		
	}
	this.addCity=function(cityArray){
		var l=cityArray.length;
		for(var i=0;i<l;i++)
		this.cities.push(new City(cityArray[i].code,cityArray[i].name,cityArray[i].stateCode));
		
	}
	this.addCampus=function(campus){
		
		this.campuses.push(new Campus(campus.code,campus.name,campus.address,campus.cityCode,campus.zipCode));	
	}
	this.addStream=function(streamArray){
		var l=streamArray.length;
		for(var i=0;i<l;i++)
		this.streams.push(new Stream(streamArray[i].code,streamArray[i].name,streamArray[i].fullName));
		
	}
	this.addBranch=function(branchArray){
		var l=branchArray.length;
		for(var i=0;i<l;i++)
		this.branches.push(new Branch(branchArray[i].code,branchArray[i].name,branchArray[i].fullName,branchArray[i].streamCode));
		
	}
}










































function AdminView()
{
	this.showErrorPage=function(){
		//alert("error");

	}
	this.updateCountryView=function(countryModel)
	{
		var countries=countryModel.countries;
		var l=countries.length;
						var i=0;
						while(i<l)
						{
						alert(" total data : "+i+" "+countries[i].code+countries[i].name);
						i++;
						}
		//code to show the data on homepage
		//this is called by adminController 
	}

	this.updateStateView=function(stateModel)
	{
		var states=stateModel.states;
		var l=states.length;
						var i=0;
						while(i<l)
						{
						alert(" total data : "+i+" "+states[i].code+" "+states[i].name+"  "+states[i].countryCode);
						i++;
						}
		//code to show the data on homepage
		//this is called by adminController 
	}
	this.updateCityView=function(cityModel)
	{
		var cities=cityModel.cities;
		var l=cities.length;
						var i=0;
						while(i<l)
						{
						alert(" total data : "+i+" "+cities[i].code+" "+cities[i].name+"  "+cities[i].stateCode);
						i++;
						}
		//code to show the data on homepage
		//this is called by adminController 
	}


	this.updateView=function(model)
	{
		//load the data by picking up data from model  arrays
		//alert("chla");
	}
//checkbox me data dalne ka kaam bhi model se hi karege ....getCountry ko request send nahi karege
//onload sara data mngwa lege.
}


//now the user
//ramesh ka code

var adminController;

// ramesh ka code 
function addCountry(tableID) {
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var countries=[];
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				//var chkbox = row.cells[0].childNodes[0];
				var countryName=row.cells[2].childNodes[0];
				//row k third column me textbox he
				if(countryName.value!="") 
				{
				countries.push(new Country(0,countryName.value));
				}}
				//alert("ramesh ka addCountry chla")
				if(countries.length==0)
				{
					alert("enter atleast one country name");
					return;
				}

				//call the add method of adminController
				adminController.addCountry(countries,function(countries){
					//we will remove the below code after testing
					var l=countries.length;
						var i=0;
						while(i<l)
						{
						alert(countries[i].name +"added successfully with code "+countries[i].code);
						i++;
						}
						document.getElementById('resetAddCountryForm').click();
						
				},function(exceptions){
					//exception occurs while adding this countries
					//we will remove the below code after testing
						var l=exceptions.length;
						var i=0;
						while(i<l)
						{
						alert(exceptions[i]);
						i++;
						}
				});
			
			}catch(e) {
				alert("abc :"+e);
			}
		}



function addState(tableID,dropDownId) {
			try {
				//alert("addState chla");
			var countryCode=document.getElementById(dropDownId).value;
			if(countryCode==0)
			{
				alert("select country");
				return;
			}
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var states=[];
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				//var chkbox = row.cells[0].childNodes[0];
				var stateName=row.cells[2].childNodes[0];
				//row k third column me textbox he
				if(stateName.value!="") 
				{
				states.push(new State(0,stateName.value,countryCode));
				}}
				//alert("ramesh ka addCountry chla")
				if(states.length==0)
				{
					alert("enter atleast one state name");
					return;
				}

				//call the add method of adminController
				//done done
				adminController.addState(states,function(states){
					//we will remove the below code after testing
					var l=states.length;
						var i=0;
						while(i<l)
						{
						alert(states[i].name +"added successfully with code "+states[i].code);
						i++;
						}
						document.getElementById('resetAddStateForm').click();
				},function(exceptions){
					//exception occurs while adding this countries
					//we will remove the below code after testing
						var l=exceptions.length;
						var i=0;
						while(i<l)
						{
						alert(exceptions[i]);
						i++;
						}
				});
			
			}catch(e) {
				alert("abc :"+e);
			}
		}




function addCity(tableID,dropDownId) {
			try {
				//alert("addState chla");
			var stateCode=document.getElementById(dropDownId).value;
			if(stateCode==0)
			{
				alert("select state");
				return;
			}
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var cities=[];
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				//var chkbox = row.cells[0].childNodes[0];
				var cityName=row.cells[2].childNodes[0];
				//row k third column me textbox he
				if(cityName.value!="") 
				{
				cities.push(new City(0,cityName.value,stateCode));
				}}
				//alert("ramesh ka addCountry chla")
				if(cities.length==0)
				{
					alert("enter atleast one city name");
					return;
				}

				//call the add method of adminController
				//done done
				adminController.addCity(cities,function(cities){
					//we will remove the below code after testing
					var l=cities.length;
						var i=0;
						while(i<l)
						{
						alert(cities[i].name +"  added successfully with code "+cities[i].code);
						i++;
						}
						document.getElementById('resetAddCityForm').click();
				},function(exceptions){
					//exception occurs while adding this countries
					//we will remove the below code after testing
						var l=exceptions.length;
						var i=0;
						while(i<l)
						{
						alert(exceptions[i]);
						i++;
						}
				});
			
			}catch(e) {
				alert("abc :"+e);
			}
		}
function addCampus(formId)
{
	var campusName;
	var address;
	var cityCode;
	var zipCode;
	var frm=document.getElementById(formId);
	campusName=frm.elements.namedItem("campusName").value;
	address=frm.elements.namedItem("address").value;
	cityCode=frm.elements.namedItem("city").value;
	zipCode=frm.elements.namedItem("zipCode").value;
	var flag=0;
	if(campusName=="") {alert("enter campus name"); flag=1};
	if(address==""){alert("enter address"); flag=1;}
	if(cityCode==0) {alert("select city"); flag=1;}
	if(zipCode=="") {alert("enter zipcode");flag=1;}//code for validating zipcode
	//prepare an array of error message and check the size of array if >0 then return and show errormessagae of form validation
	if (flag) { return;}

	adminController.addCampus(new Campus(0,campusName,address,cityCode,zipCode),function(campus){
		alert("campus added successfully with code "+campus.code)
		document.getElementById('resetAddCampusForm').click();

	},function(exception){
		alert(exception);
	});
	

}



function addStream(tableID) {
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var streams=[];
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				//var chkbox = row.cells[0].childNodes[0];
				var streamName=row.cells[2].childNodes[0];
				//row k third column me textbox he
				var fullName=row.cells[4].childNodes[0];
				//row k fifth column me textbox he

				if(streamName.value!="" && fullName.value!="") 
				{
				streams.push(new Stream(0,streamName.value,fullName.value));
				}}
			
				if(streams.length==0)
				{
					alert("enter atleast one stream");
					return;
				}

				//call the add method of adminController
				adminController.addStream(streams,function(streams){
					//we will remove the below code after testing
					var l=streams.length;
						var i=0;
						while(i<l)
						{
						alert(streams[i].name+" : "+streams[i].fullName +"  added successfully with code "+streams[i].code);
						i++;
						}
						document.getElementById('resetAddStreamForm').click();
						
				},function(exceptions){
					//exception occurs while adding this countries
					//we will remove the below code after testing
						var l=exceptions.length;
						var i=0;
						while(i<l)
						{
						alert(exceptions[i]);
						i++;
						}
				});
			
			}catch(e) {
				alert("abc :"+e);
			}
		}




function addBranch(tableID,dropdownId) {
			try {
			var streamCode=document.getElementById(dropdownId).value;
			if(streamCode==0)
			{
				alert("select stream");
				return;
			}
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var branches=[];
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				//var chkbox = row.cells[0].childNodes[0];
				var branchName=row.cells[2].childNodes[0];
				//row k third column me textbox he
				var fullName=row.cells[4].childNodes[0];
				//row k fifth column me textbox he

				if(branchName.value!="" && fullName.value!="") 
				{
				branches.push(new Branch(0,branchName.value.trim(),fullName.value.trim(),streamCode));
				}}
			
				if(branches.length==0)
				{
					alert("enter atleast one branch");
					return;
				}

				//call the add method of adminController
				adminController.addBranch(branches,function(branches){
					//we will remove the below code after testing
					var l=branches.length;
						var i=0;
						while(i<l)
						{
						alert(branches[i].name+" : "+branches[i].fullName +"  added successfully with code "+branches[i].code);
						i++;
						}
						document.getElementById('resetAddBranchForm').click();
						
				},function(exceptions){
					//exception occurs while adding this countries
					//we will remove the below code after testing
						var l=exceptions.length;
						var i=0;
						while(i<l)
						{
						alert(exceptions[i]);
						i++;
						}
				});
			
			}catch(e) {
				alert("abc :"+e);
			}
		}



function addBranchSeats(formId,tbodyId) {
			try {
			var frm=document.getElementById(formId);
			var campusCode=frm.elements.namedItem("campus").value;
			var streamCode=frm.elements.namedItem("stream").value;
			//var tbl=frm.getElementsByTagName('table');
			var tbd=document.getElementById(tbodyId);
			//alert(tbd.rows.length);
			//we cant acces table by frm.elements.namedItem() only input button select are the parts of frm.elements
			//alert(campusCode+" "+streamCode+" "+tbd);
			var f=0;
			if (campusCode==0) {alert("select campus");f=1;}
			if(streamCode==0) {alert("select stream ");f=1;}
			if(l<1) return;
			var l=tbd.rows.length;
			for(j=0;j<l;j++)
			{
				var val=tbd.rows[j].cells[2].childNodes[0].value;
				if(val=="") {alert("enter no. of seats for "+tbd.rows[j].cells[1].childNodes[0].innerHTML); f=1;}
			}
			
			if(f) return;
			var branchSeats=[];
			for(j=0;j<l;j++)
			{
				var branchCode=tbd.rows[j].cells[0].childNodes[0].value;
			    var seats=tbd.rows[j].cells[2].childNodes[0].value;
				branchSeats.push(new BranchSeats(campusCode,streamCode,branchCode,seats.trim()))
			}
			
				//call the add method of adminController
				adminController.addBranchSeats(branchSeats,function(msg){
					//we will remove the below code after testing
					alert(msg);
						
				},function(exception){
					//exception occurs while adding this countries
					//we will remove the below code after testing
						alert(exception);
				});
			
			}catch(e) {
				alert("abc :"+e);
			}
		}













function getCountryList(dropdownId)
{
	var c;
	adminController.getCountryList(function(countries){
	c=countries;
	var d=document.getElementById(dropdownId);
	var i=0;
	var o;
	while(i<c.length)
	{
	o=document.createElement('OPTION');
	o.innerHTML=c[i].name;
	o.value=c[i].code;
	d.appendChild(o);
	//alert("added to option : "+c[i].name);
	i++;
	}
	//code to fillup the dropdown 
	});
	//alert(c);
	return c;
}



function getStateList(countryCode,dropdownId)
{
	adminController.getStateList(countryCode,function(states){
	var d=document.getElementById(dropdownId);
	while(d.children[1]) 
	{
		d.removeChild(d.children[1]);
	}
	var i=0;
	var o;
	
	//return;
	while(i<states.length)
	{
	o=document.createElement('OPTION');
	o.innerHTML=states[i].name;
	o.value=states[i].code;
	d.appendChild(o);
	//alert("added to option : "+c[i].name);
	i++;
	}
	//code to fillup the dropdown 
	});
	//alert(c);
	//return c;
}

function getCityList(stateCode,dropdownId)
{
	adminController.getCityList(stateCode,function(cities){
	var d=document.getElementById(dropdownId);
	
	while(d.children[1]) 
	{
		d.removeChild(d.children[1]);
	}
	var i=0;
	var o;
	//return;
	while(i<cities.length)
	{
	o=document.createElement('OPTION');
	o.innerHTML=cities[i].name;
	o.value=cities[i].code;
	d.appendChild(o);
	;
	i++;
	}

	});

}

function getCampusList(dropdownId)
{
	adminController.getCampusList(function(campuses){
	var d=document.getElementById(dropdownId);
	
	while(d.children[1]) 
	{
		d.removeChild(d.children[1]);
	}
	var i=0;
	var o;
	//return;
	while(i<campuses.length)
	{
	o=document.createElement('OPTION');
	o.innerHTML=campuses[i].name;//we can display full name too
	o.value=campuses[i].code;
	d.appendChild(o);
	;
	i++;
	}

	});

}

function getStreamList(dropdownId)
{
	adminController.getStreamList(function(streams){
	var d=document.getElementById(dropdownId);
	
	while(d.children[1]) 
	{
		d.removeChild(d.children[1]);
	}
	var i=0;
	var o;
	//return;
	while(i<streams.length)
	{
	o=document.createElement('OPTION');
	o.innerHTML=streams[i].name;//we can display full name too
	o.value=streams[i].code;
	d.appendChild(o);
	;
	i++;
	}
	});

}
function getBranchSeatsForm(tableID,streamCode)
{
adminController.getBranchList(streamCode,function(branches){
			var tbody = document.getElementById(tableID);
			while(tbody.children[0])
			{
				tbody.removeChild(tbody.children[0]);
			}

			var i=0;
			var l=branches.length;
			while(i<l)
			{
			var tr=document.createElement('tr');
			var td=document.createElement('td');
			var label=document.createElement('label');
			label.innerHTML=branches[i].name;
			label.value=branches[i].code;
			td.appendChild(label);
			tr.appendChild(td);
			 td=document.createElement('td');
			 label=document.createElement('label');
			label.innerHTML=branches[i].fullName;
			td.appendChild(label);
			tr.appendChild(td);
			td=document.createElement('td');
			 var txt=document.createElement('input');
			 txt.style="type:number;padding:none;readonly";
			 //txt.style.type="number";
			td.appendChild(txt);
			tr.appendChild(td);
			tbody.appendChild(tr);
			i++;
			}	

});
}
//ramesh ki add chalegi and vo adminController ki add ko call forword karegi then adminController ki add service 
//ki add ko call forword karegi
function initialize()
{
	adminController=new AdminController();
	adminController.loadData();
}

window.addEventListener('load',initialize);