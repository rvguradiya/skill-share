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



public class GetCountry extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
//ArrayList<String> exceptions=new ArrayList<>();
//no any exception get generated
//List<CountryDTO> result; no need directly CountryResponse.result= krege
ApplicationResponse applicationResponse=new ApplicationResponse();
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
String jsonString="";
try
{
//this try is for daoexceptions like database server is stopped or and sqlexception but there is no
//need for this try catch block beacause we do not interact with database this time 
//we get data from servlet context.
//but we keep it because it harm nothing
//Connection connection=DAOConnection.getConnection();
//no need of connection
ServletContext servletContext=getServletContext();
applicationResponse.result=servletContext.getAttribute("countries");
applicationResponse.isSuccess=true;
}
catch(Exception e)
{
applicationResponse.error="error while fetching data from data structure : "+e.getMessage();
applicationResponse.isError=true;
}
jsonString=gson.toJson(applicationResponse);
pw.print(jsonString);
}catch(Exception exception)
{
System.out.println("Error in GetCountry Servlet : "+exception); // remove after testing
}

}

}