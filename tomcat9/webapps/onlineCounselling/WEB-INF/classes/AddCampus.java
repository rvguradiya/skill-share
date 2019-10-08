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

public class AddCampus extends HttpServlet
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
ApplicationResponse applicationResponse=new ApplicationResponse();
/*****************************step 2. dl layer code start**********************/
try
{
Connection connection=DAOConnection.getConnection();
CampusDTO campus=gson.fromJson(jsonString,CampusDTO.class); //parse json string to java object
System.out.println(campus.getName());
System.out.println(campus.getAddress());
System.out.println(campus.getCityCode());
System.out.println(campus.getZipCode());

ServletContext servletContext=getServletContext();
HashMap<String,CampusDTO> map=(HashMap<String,CampusDTO>)servletContext.getAttribute("campusesMap");
List<CampusDTO> campusesFromDS=(LinkedList<CampusDTO>)servletContext.getAttribute("campuses");
//for updating the ds if the data is added  into database successfully

PreparedStatement preparedStatement;
ResultSet resultSet;
/***************code to check that data is already exists or not*********************************/
if(map.containsKey(campus.getName().toUpperCase()))
{
applicationResponse.isException=true;
applicationResponse.exceptions=new  String(campus.getName()+"  exists!");
//we will safe from firing the query again and again to check the existence of data in tables
}
else
{
//code to add the data in databse
preparedStatement=connection.prepareStatement("insert into campus(name,address,city_code,zip_code) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,campus.getName());
preparedStatement.setString(2,campus.getAddress());
preparedStatement.setInt(3,campus.getCityCode());
preparedStatement.setInt(4,campus.getZipCode());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
campus.setCode(resultSet.getInt(1));
map.put(campus.getName().toUpperCase(),campus);
campusesFromDS.add(campus);
resultSet.close();
preparedStatement.close();
applicationResponse.result=campus;
applicationResponse.isSuccess=true;
}

connection.close();
}catch(SQLException sqlException)
{
applicationResponse.isException=true;
applicationResponse.exceptions=new  String("Exception: "+sqlException);
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
System.out.println("unexpected error in AddCampus servlet : "+exception); // remove after testing
}

}

}