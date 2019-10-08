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



public class GetCampus extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
ApplicationResponse applicationResponse=new ApplicationResponse();
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
String jsonString="";
try
{
ServletContext servletContext=getServletContext();
applicationResponse.result=servletContext.getAttribute("campuses");
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
System.out.println("Error in GetCampus Servlet : "+exception); // remove after testing
}

}

}