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

public class AddStream extends HttpServlet
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
ArrayList<StreamDTO> result=new ArrayList<>();//for storing results
ApplicationResponse applicationResponse=new ApplicationResponse();
/*****************************step 2. dl layer code start**********************/
try
{
Connection connection=DAOConnection.getConnection();
StreamRequest streamRequest=gson.fromJson(jsonString,StreamRequest.class); //parse json string to java object
ArrayList<StreamDTO> streams=(ArrayList<StreamDTO>)streamRequest.getStreams(); //to store the list of dto's that arrives as request
int i=0,size=streams.size();
StreamDTO stream;
ServletContext servletContext=getServletContext();
HashMap<String,StreamDTO> map=(HashMap<String,StreamDTO>)servletContext.getAttribute("streamsMap");
//System.out.println(map);
List<StreamDTO> streamsFromDS=(LinkedList<StreamDTO>)servletContext.getAttribute("streams");
PreparedStatement preparedStatement;
ResultSet resultSet;
while(i<size)
{
stream=streams.get(i);

/***************code to check that data is already exists or not*********************************/
if(map.containsKey(stream.getName().toUpperCase()+" "+stream.getFullName().toUpperCase()))
{
applicationResponse.isException=true;
exceptions.add(stream.getName()+"  exists!");
//we will safe from firing the query again and again to check the existence of data in tables
}
else
{
//code to add the data in databse
preparedStatement=connection.prepareStatement("insert into stream(name,full_name) values(?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,stream.getName());
preparedStatement.setString(2,stream.getFullName());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
stream.setCode(resultSet.getInt(1));
map.put(stream.getName().toUpperCase()+" "+stream.getFullName().toUpperCase(),stream);
streamsFromDS.add(stream);
resultSet.close();
preparedStatement.close();
result.add(stream);  //add the result to list
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
System.out.println("unexpected error in AddStream servlet : "+exception); // remove after testing
}

}

}