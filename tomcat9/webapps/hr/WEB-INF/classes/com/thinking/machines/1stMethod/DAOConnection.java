package com.thinking.machines.hr;
import java.sql.*;
public class DAOConnection 
{
private DAOConnection()
{
} 
public static Connection getConnection() throws DAOException { 
Connection connection=null; 
try 
{ 
Class.forName("org.apache.derby.jdbc.ClientDriver"); 
connection=DriverManager.getConnection("jdbc:derby://localhost:1527/hrdb"); 
return connection; 
}catch(SQLException sqlException) 
{ System.out.println(sqlException); // remove after testing 
throw new DAOException(sqlException.getMessage()); 
} catch(ClassNotFoundException classNotFoundException) 
{ 
System.out.println(classNotFoundException); // remove after testing 
throw new DAOException(classNotFoundException.getMessage()); 
} 
} 
} 