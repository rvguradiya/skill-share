package com.thinking.machines.sandeephr;
import java.sql.*;
public class DAOConnection
{
private DAOConnection()
{}
public static Connection getConnection() throws DAOException
{
Connection connection=null;
try
{
Class.forName("org.apache.derby.jdbc.ClientDriver");
connection=DriverManager.getConnection("jdbc:derby://localhost:1527/sandeepdb");
return connection;
}
catch(SQLException sqlException)
{
System.out.println(sqlException);
throw new DAOException(sqlException.getMessage());
}
catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe.getMessage());
throw new DAOException(cnfe.getMessage());
}
}
}