package com.thinking.machines.sandeephr;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class GetEmployees extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("Text/html");
pw.println("<!Doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>whatever</title>");
pw.println("<script>");
pw.println("function deleteEmployee(name,code)");
pw.println("{");
pw.println("var c=confirm('delete  '+name+'?');");
pw.println("if(c)");
pw.println("{");
pw.println("var frm=getElementById('employeeDeleteForm');");
pw.println("frm.code.value=code");
pw.println("frm.submit()");
pw.println("}");
pw.println("}");
pw.println("</script>"); 


pw.println("<script>");
pw.println("function editEmployee(code)");
pw.println("{ ");
pw.println("var frm=document.getElementById('employeeEditForm');");
pw.println("frm.code.value=code;");
pw.println("frm.submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h1>employees</h1>");
pw.println("<table>");
pw.println("<tr>");      //extra tr
pw.println("<td   align='right'>");
pw.println("<a href='/sandeephr/EmployeeAddForm.html'><img src='sandeephr/images/add_icon.png'></a>");
pw.println("</td>");


pw.println("</tr>");
pw.println("<td>");   //extra td
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println(" <tr>");
pw.println(" <th>S.No.</th>");
pw.println("<th>Name</th>");
pw.println("<th>Gender</th>");
pw.println("<th>Permanent</th>");
pw.println("<th>Contact</th>");
pw.println("<th>City</th>");
pw.println("<th>Edit</th>");
pw.println("<th>Delete</th>");

pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("Select * from employee order by first_name,last_name");
if(resultSet.next()==false)
{
pw.println("<tr >");
pw.println("<td colspan='7' align='center'>No Employees</td>");
pw.println("</tr>");
}
else
{
int code;
String firstName;
String lastName;
String gender;
String isPermanent;
String contact;
String city;
int sno=0;
do
{
sno++;
code=resultSet.getInt("code");
firstName=resultSet.getString("first_name").trim();
lastName=resultSet.getString("last_name").trim();
gender=resultSet.getString("gender");
isPermanent=resultSet.getString("is_permanent");
contact=resultSet.getString("contact");
city=resultSet.getString("city").trim();
pw.println("<tr>");
pw.println("<td align='right'>"+sno+"</td>");
pw.println("<td>"+firstName+" " +lastName+"</td>");
if(gender.equals("M"))
{
pw.println("<td align='center'><img src='/sandeephr/images/male_icon.png'></td>");
}
else
{
pw.println("<td align='center'><img src='/sandeephr/images/female_icon.png'></td>");
}
if(isPermanent.equals("Y"))
{
pw.println("<td align='center'><img src='/sandeephr/images/checked_icon.png'></td>");
}
else
{
pw.println("<td align='center'><img src='/sandeephr/images/unchecked_icon.png'></td>");
}
pw.println("<td>"+contact+"</td>");
pw.println("<td>"+city+"</td>");
pw.println("<td align='center'>");
pw.println("<a href=\"javascript:editEmployee("+code+")\"><img src='/sandeephr/images/edit_icon.png'></a>");
pw.println("</td>");
pw.println("<td>");
pw.println("<a href=\"javascript:deleteEmployee('"+firstName+" "+lastName+"',"+code+")\"><img src='/sandeephr/images/delete_icon.png'></a>");
pw.println("</td>");

pw.println("</tr>");
}while(resultSet.next());
resultSet.close();
connection.close();
pw.println("</tbody>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");

pw.println("</body>");
}
}catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}