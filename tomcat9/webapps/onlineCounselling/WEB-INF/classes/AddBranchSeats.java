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

public class AddBranchSeats extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
/******************step1. read the request as string*******************************************/
BufferedReader br=request.getReader();
String line;
String jsonString="";
System.out.println(br);
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
BranchSeatsRequest branchSeatsRequest=gson.fromJson(jsonString,BranchSeatsRequest.class); //parse json string to java object
ArrayList<BranchSeatsDTO> branchSeats=(ArrayList<BranchSeatsDTO>)branchSeatsRequest.getBranchSeats(); //to store the list of dto's that arrives as request
int i=0,size=branchSeats.size();
BranchSeatsDTO bs;
ServletContext servletContext=getServletContext();
HashSet<String> campusStreamSet=(HashSet<String>)servletContext.getAttribute("campusStreamSet");
HashSet<String> campusStreamBranchSet=(HashSet<String>)servletContext.getAttribute("campusStreamBranchSet");
bs=branchSeats.get(0);
System.out.println(bs);
String bss;


PreparedStatement preparedStatement;
ResultSet resultSet;
while(i<size)
{

bs=branchSeats.get(i);


bss=bs.getCampusCode()+" "+bs.getStreamCode()+" "+bs.getBranchCode();
if(campusStreamBranchSet.contains(bss))
{
//applicationResponse.isException=true;
//applicationResponse.exceptions="branch seats in the given stream for the  given campus are already added";
preparedStatement=connection.prepareStatement("update campus_stream_branch set no_of_seats=? where ((campus_code=? and stream_code=?) and branch_code=?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setInt(2,bs.getCampusCode());
preparedStatement.setInt(3,bs.getStreamCode());
preparedStatement.setInt(4,bs.getBranchCode());
preparedStatement.setInt(1,bs.getSeats());
preparedStatement.executeUpdate();
preparedStatement.close();
}
else
{



preparedStatement=connection.prepareStatement("insert into campus_stream_branch(campus_code,stream_code,branch_code,no_of_seats) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setInt(1,bs.getCampusCode());
preparedStatement.setInt(2,bs.getStreamCode());
preparedStatement.setInt(3,bs.getBranchCode());
preparedStatement.setInt(4,bs.getSeats());
preparedStatement.executeUpdate();
preparedStatement.close();
campusStreamBranchSet.add(Integer.toString(bs.getCampusCode())+" "+Integer.toString(bs.getStreamCode())+" "+Integer.toString(bs.getBranchCode()));
if(!(campusStreamSet.contains(Integer.toString(bs.getCampusCode())+" "+Integer.toString(bs.getStreamCode()))))
{
preparedStatement=connection.prepareStatement("insert into campus_stream(campus_code,stream_code) values(?,?)");
preparedStatement.setInt(1,bs.getCampusCode());
preparedStatement.setInt(2,bs.getStreamCode());
preparedStatement.executeUpdate();
preparedStatement.close();
campusStreamSet.add(Integer.toString(bs.getCampusCode())+" "+Integer.toString(bs.getStreamCode()));
}
}
i++;
}
applicationResponse.result="addedd successfully !";
applicationResponse.isSuccess=true;


connection.close();
}catch(SQLException sqlException)
{
applicationResponse.exceptions="Exception: "+sqlException;
applicationResponse.isException=true;
}


/*****************************dl layer code ends******************************************/
catch(Exception e)
{
//System.out.println("unexpected error in AddBranchSeats servlet : "+e);
applicationResponse.error="Error is:  "+e;
applicationResponse.isError=true;
 // remove after testing
//e.printStackTrace(); // remove after testing
}
jsonString=gson.toJson(applicationResponse);
pw.print(jsonString);
}catch(Exception exception)
{
//error related to connection or any other null pointer exception
//System.out.println("unexpected error in AddBranchSeats servlet : "+exception); // remove after testing
}
}

}