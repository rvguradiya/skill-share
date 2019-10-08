package dl;
import java.sql.*;
public class DAOConnection
{
private DAOConnection(){}
public static Connection getConnection()
{ 
try
{

Class.forName("org.apache.derby.jdbc.ClientDriver");
Connection connection;
connection=DriverManager.getConnection("jdbc:derby://localhost:1527/counsellingdb");

return connection;
}catch(Exception e)
{
return null;
}
}
}