


<%@ page import="java.sql.*" %>
<%@ page import="DAOConnection" %>
<%
 String st=request.getParameter("nm");
 System.out.println(st);
try
{
Connection con=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=con.prepareStatement("insert into abhishek(id,name) values(?,?)");
preparedStatement.setInt(1,9);
preparedStatement.setString(2,st);
preparedStatement.executeUpdate();
}catch(Exception e)
{
System.out.println("exce"+e);
}
%>
