package com.thinking.machines.hr;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class DeleteEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String code=request.getParameter("code");
if(code==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/getEmployees");
requestDispatcher.forward(request,response);
return;
}
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("delete from employee where code=?");
preparedStatement.setInt(1,Integer.parseInt(code));
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/getEmployees");
requestDispatcher.forward(request,response);
}catch(Exception e)
{
System.out.println(e); // remove after testing
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}