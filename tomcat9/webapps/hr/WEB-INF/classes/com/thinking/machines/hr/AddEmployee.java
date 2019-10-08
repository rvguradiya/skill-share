package com.thinking.machines.hr;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class AddEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
BufferedReader br=request.getReader();
String line;
String jsonString="";
while(true)
{
line=br.readLine();
if(line==null) break;
jsonString+=line;
}
System.out.println("Raw string : "+jsonString);
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
ApplicationResponse applicationResponse=new ApplicationResponse();
try
{
EmployeeBeanInterface employee=gson.fromJson(jsonString,EmployeeBean.class);
EmployeeDTOInterface dlEmployee=new EmployeeDTO();
dlEmployee.setFirstName(employee.getFirstName());
dlEmployee.setLastName(employee.getLastName());
dlEmployee.setGender(employee.getGender());
dlEmployee.setCity(employee.getCity());
dlEmployee.setIsPermanent((employee.getIsPermanent())?"Y":"N");
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDAO.add(dlEmployee);
EmployeeBeanInterface employeeBean;
employeeBean=new EmployeeBean();
employeeBean.setCode(dlEmployee.getCode());
employeeBean.setFirstName(dlEmployee.getFirstName());
employeeBean.setLastName(dlEmployee.getLastName());
employeeBean.setGender(dlEmployee.getGender());
employeeBean.setCity(dlEmployee.getCity());
employeeBean.setIsPermanent(dlEmployee.getIsPermanent().equals("Y"));
applicationResponse.result=employeeBean;
applicationResponse.isSuccess=true;
}catch(DAOException daoException)
{
applicationResponse.isException=true;
applicationResponse.exception=daoException.getMessage();
}
catch(Exception exception)
{
applicationResponse.error=exception.getMessage();
}
jsonString=gson.toJson(applicationResponse);
pw.print(jsonString);
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}