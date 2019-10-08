 package com.thinking.machines.hr.dl;
import java.util.*;
import java.sql.*;
public class EmployeeDAO implements EmployeeDAOInterface
{
public void add(EmployeeDTOInterface employeeDTOInterface) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from employee where first_name=? and last_name=?");
preparedStatement.setString(1,employeeDTOInterface.getFirstName());
preparedStatement.setString(2,employeeDTOInterface.getLastName());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Employee exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into employee(first_name,last_name,gender,is_permanent,city) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,employeeDTOInterface.getFirstName());
preparedStatement.setString(2,employeeDTOInterface.getLastName());
preparedStatement.setString(3,employeeDTOInterface.getGender());
preparedStatement.setString(4,employeeDTOInterface.getIsPermanent());
preparedStatement.setString(5,employeeDTOInterface.getCity());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
employeeDTOInterface.setCode(resultSet.getInt(1));
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public void update(EmployeeDTOInterface employee) throws DAOException
{
throw new DAOException("Not yet implemented");
}
public void delete(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from employee where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid code : "+code);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from employee where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public ArrayList<EmployeeDTOInterface> getEmployees() throws DAOException
{
ArrayList<EmployeeDTOInterface> employees=new ArrayList<EmployeeDTOInterface>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select * from employee");
EmployeeDTOInterface employee;
while(resultSet.next())
{
employee=new EmployeeDTO();
employee.setCode(resultSet.getInt("code"));
employee.setFirstName(resultSet.getString("first_name").trim());
employee.setLastName(resultSet.getString("last_name").trim());
employee.setGender(resultSet.getString("gender").trim());
employee.setIsPermanent(resultSet.getString("is_permanent").trim());
employee.setCity(resultSet.getString("city").trim());
employees.add(employee);
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return employees;
}
public long getCount() throws DAOException
{
throw new DAOException("Not yet implemented");
}
public EmployeeDTOInterface getByCode(int code) throws DAOException
{
throw new DAOException("Not yet implemented");
}
}