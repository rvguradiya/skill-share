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

public class AddBranch extends HttpServlet
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
ArrayList<BranchDTO> result=new ArrayList<>();//for storing results
ApplicationResponse applicationResponse=new ApplicationResponse();
/*****************************step 2. dl layer code start**********************/
try
{
Connection connection=DAOConnection.getConnection();
BranchRequest branchRequest=gson.fromJson(jsonString,BranchRequest.class); //parse json string to java object
ArrayList<BranchDTO> branches=(ArrayList<BranchDTO>)branchRequest.getBranches(); //to store the list of dto's that arrives as request
int i=0,size=branches.size();
BranchDTO branch;
ServletContext servletContext=getServletContext();
HashMap<String,BranchDTO> map=(HashMap<String,BranchDTO>)servletContext.getAttribute("branchesMap");
HashSet<String> streamBranchSet=(HashSet<String>)servletContext.getAttribute("streamBranchSet");
//System.out.println(map);
List<BranchDTO> branchesFromDS=(LinkedList<BranchDTO>)servletContext.getAttribute("branches");
PreparedStatement preparedStatement;
ResultSet resultSet;
while(i<size)
{
branch=branches.get(i);

/***************code to check that data is already exists or not*********************************/
if(map.containsKey(branch.getName().toUpperCase())||map.containsKey(branch.getFullName().toUpperCase()))
{
BranchDTO b=map.get(branch.getName().toUpperCase());//if these key is not in map but another key is exist.
if(b==null) b=map.get(branch.getFullName().toUpperCase());
branch.setCode(b.getCode());
//dono unique key ko map me rakha tha unme se ek k against object rkha tha baki k against null rakha tha
//the below condition is for checking the existance of stream_branch mapping  because if branch exist already then we dont 
//jump into else and and cant able to add data in branch stream mapping 
//because diffrent stream can  have same branch. e.g. b.tech and m.tech both have civil branch 
// so if branch exist then we have to check that branch is exist against that stream or not in stream branch mapping.
if(!(streamBranchSet.contains(Integer.toString(branch.getStreamCode())+" "+Integer.toString(branch.getCode()))))
{
preparedStatement=connection.prepareStatement("insert into stream_branch(stream_code,branch_code) values(?,?)");
preparedStatement.setInt(1,branch.getStreamCode());
preparedStatement.setInt(2,branch.getCode());
preparedStatement.executeUpdate();
preparedStatement.close();
streamBranchSet.add(Integer.toString(branch.getStreamCode())+" "+Integer.toString(branch.getCode()));
result.add(branch);  //add the result to list
applicationResponse.isSuccess=true;
}
else
{
applicationResponse.isException=true;
exceptions.add(branch.getName()+" : "+branch.getFullName()+"  exists! in this stream");
//we will safe from firing the query again and again to check the existence of data in tables
}
}
else
{
//code to add the data in databse
preparedStatement=connection.prepareStatement("insert into branch(name,full_name) values(?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,branch.getName());
preparedStatement.setString(2,branch.getFullName());
System.out.println(branch.getFullName().length());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
branch.setCode(resultSet.getInt(1));
map.put(branch.getName().toUpperCase(),branch);
map.put(branch.getFullName().toUpperCase(),null);
branchesFromDS.add(branch);
resultSet.close();
preparedStatement.close();
result.add(branch);  //add the result to list
applicationResponse.isSuccess=true;

//add the data to mapping table
//if(!(streamBranchSet.contains(Integer.toString(branch.getStreamCode())+" "+Integer.toString(branch.getCode()))))
//{ no need to check in set here
preparedStatement=connection.prepareStatement("insert into stream_branch(stream_code,branch_code) values(?,?)");
preparedStatement.setInt(1,branch.getStreamCode());
preparedStatement.setInt(2,branch.getCode());
preparedStatement.executeUpdate();
preparedStatement.close();
streamBranchSet.add(Integer.toString(branch.getStreamCode())+" "+Integer.toString(branch.getCode()));
//}



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
System.out.println("unexpected error in AddBranch servlet : "+exception); // remove after testing
}

}

}