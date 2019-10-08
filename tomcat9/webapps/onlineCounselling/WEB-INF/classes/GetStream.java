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



public class GetStream extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
//ArrayList<String> exceptions=new ArrayList<>();
//no any exception get generated
//List<StreamDTO> result; no need directly StreamResponse.result= krege
ApplicationResponse applicationResponse=new ApplicationResponse();
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
String jsonString="";
try
{

ServletContext servletContext=getServletContext();
applicationResponse.result=servletContext.getAttribute("streams");
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
System.out.println("Error in GetStream Servlet : "+exception); // remove after testing
}

}

}