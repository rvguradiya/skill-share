import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import com.google.gson.*;

import dl.*;
import dto.*;
import request.*;
import response.*;

public class AddCountry extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
/******************step1. read the request as string*******************************************/
BufferedReader br=request.getReader();
String line;
String jsonString="";
while(true)
{
line=br.readLine();
if(line==null) break;
jsonString+=line;
}
//System.out.println("Raw string : "+jsonString);
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
ArrayList<String> exceptions=new ArrayList<>(); //for storing list of exceptions
ArrayList<CountryDTO> result=new ArrayList<>();//for storing results
ApplicationResponse applicationResponse=new ApplicationResponse();
/*****************************step 2. dl layer code start**********************/
try
{
Connection connection=DAOConnection.getConnection();
CountryRequest countryRequest=gson.fromJson(jsonString,CountryRequest.class); //parse json string to java object
ArrayList<CountryDTO> countries=(ArrayList<CountryDTO>)countryRequest.getCountries(); //to store the list of dto's that arrives as request
int i=0,size=countries.size();
CountryDTO country;
ServletContext servletContext=getServletContext();
HashMap<String,CountryDTO> map=(HashMap<String,CountryDTO>)servletContext.getAttribute("countriesMap");
List<CountryDTO> countriesFromDS=(LinkedList<CountryDTO>)servletContext.getAttribute("countries");
PreparedStatement preparedStatement;
ResultSet resultSet;
while(i<size)
{
country=countries.get(i);

/***************code to check that data is already exists or not*********************************/
if(map.containsKey(country.getName().toUpperCase()))
{
applicationResponse.isException=true;
exceptions.add(country.getName()+"  exists!");
//we will safe from firing the query again and again to check the existence of data in tables
}
else
{
//code to add the data in databse
preparedStatement=connection.prepareStatement("insert into country(name) values(?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,country.getName());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
country.setCode(resultSet.getInt(1));
map.put(country.getName().toUpperCase(),country);
countriesFromDS.add(country);
resultSet.close();
preparedStatement.close();
result.add(country);  //add the result to list
applicationResponse.isSuccess=true;
}
i++;
}
applicationResponse.result=result;
applicationResponse.exceptions=exceptions;
connection.close();
}catch(SQLException sqlException)
{
exceptions.add("Exception: "+sqlException);
applicationResponse.exceptions=exceptions;
applicationResponse.isException=true;
}


/*****************************dl layer code ends******************************************/

catch(Exception e)
{
applicationResponse.error="Error :  "+e;
applicationResponse.isError=true;
}
jsonString=gson.toJson(applicationResponse);
pw.print(jsonString);
}catch(Exception exception)
{
//error related to connection or any other null pointer exception
System.out.println("unexpected error in AddCountry servlet : "+exception); // remove after testing
}

}

}