package com.thinking.machines.hr;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class GetEmployees extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("application/json");
ArrayList<EmployeeDTOInterface> dlEmployees=new EmployeeDAO().getEmployees();
LinkedList<EmployeeBeanInterface> employees=new LinkedList<>();
int i;
i=0;
EmployeeBeanInterface employee;
EmployeeDTOInterface dlEmployee;
while(i<dlEmployees.size())
{
dlEmployee=dlEmployees.get(i);
employee=new EmployeeBean();
employee.setCode(dlEmployee.getCode());
employee.setFirstName(dlEmployee.getFirstName());
employee.setLastName(dlEmployee.getLastName());
employee.setGender(dlEmployee.getGender());
employee.setCity(dlEmployee.getCity());
employee.setIsPermanent(dlEmployee.getIsPermanent().equals("Y"));
employees.add(employee);
i++;
}
Collections.sort(employees);
ApplicationResponse applicationResponse;
applicationResponse=new ApplicationResponse();
applicationResponse.isSuccess=true;
applicationResponse.result=employees;
Gson gson=new Gson();
String jsonString=gson.toJson(applicationResponse);
PrintWriter pw=response.getWriter();
pw.print(jsonString);
}catch(DAOException daoException)
{
System.out.println(daoException); //remove after testing
}
catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}