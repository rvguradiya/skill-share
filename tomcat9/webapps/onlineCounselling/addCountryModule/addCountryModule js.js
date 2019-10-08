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
function Stream(vCode,vName,vFullName,vCampusCode)
{
	this.code=vCode;
	this.name=vName;
	this.fullName=vFullName;
	this.campusCode=vCampusCode;
}
function Branch(vCode,vName,vFullName,vNoOfSeats,vCampusCode,vStreamCode)
{
	this.code=vCode;
	this.name=vName;
	this.fullName=vFullName;
	this.noOfSeats=vNoOfSeats;
	this.campusCode=vCampusCode;
	this.streamCode=vStreamCode;
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
	}
	this.loadCityData=function(successCallBack)
	{
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
			view.updateCountryView(model);
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
		});
		service.loadCityData(function(data){
			//code to fill the model
		});
		view.updateView(model);
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



	this.updateView=function(model)
	{
		//load the data by picking up data from model  arrays
		alert("chla");
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
/*function getCountries(dropdownId)
{
var c;
alert("chala");
adminController.getCountries(function(countries){
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
alert(c);
return c;
}*/
//ramesh ki add chalegi and vo adminController ki add ko call forword karegi then adminController ki add service 
//ki add ko call forword karegi
function initialize()
{
	adminController=new AdminController();
	adminController.loadData();
}

window.addEventListener('load',initialize);