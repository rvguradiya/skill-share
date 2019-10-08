package com.thinking.machines.hr;
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
response.setContentType("Text/html");//Mime type set by us
pw.println("<!doctype html>");
pw.println("<html lang='en'>"); //en means english language
pw.println("<head>");
pw.println("<meta charset='utf-8'>");//to tell browser that it is html5 code
pw.println("<title>whatever</title>");



//function which get called when we click delete icon.(is link k href me deleteEmployee()  ko call kiya gaya h)
pw.println("<script>");
pw.println("function deleteEmployee(name,code)");
pw.println("{");
pw.println("var c=confirm('Delete '+name+' ?');");
pw.println("if(c)");
pw.println("{");
pw.println("var frm=document.getElementById('employeeDeleteForm');");
pw.println("frm.code.value=code;");
pw.println("frm.submit();");
pw.println("}");
pw.println("}");
pw.println("</script>");
//we automatically submit a form in this function and action of that form is to send request to deleteEmployee servlet


//function which get called when we click edit icon.(is link k href me editEmployee ko call kiya gaya h)
pw.println("<script>");
pw.println("function editEmployee(code)");
pw.println("{");
pw.println("var frm=document.getElementById('employeeEditForm');");
pw.println("frm.code.value=code;");
pw.println("frm.submit();");
pw.println("}");
pw.println("</script>");
//we automatically submit a form(named editEmployeeForm and exit in this html documnet) in this function and action of that form is to send request to editEmployee servlet

pw.println("</head>");
pw.println("<body>");
pw.println("<h1>Employees</h1>");
pw.println("<table>");
pw.println("<tr>");

//EmployeeAddForm.html get requested when user click add icon
pw.println("<td align='right'>");
pw.println("<a href='/hr/EmployeeAddForm.html'><img src='/hr/images/add_icon.png'></a>");
pw.println("</td>");
//and form open

pw.println("</tr>");
pw.println("<td>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th>S.No.</th>");
pw.println("<th>Name</th>");
pw.println("<th>Gender</th>");
pw.println("<th>Permanent</th>");
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
resultSet=statement.executeQuery("select * from employee order by first_name,last_name");
if(resultSet.next()==false)
{
pw.println("<tr><td colspan='7' align='center'>No employees</td></tr>");
}
else
{
int code;
String firstName;
String lastName;
String gender;
String isPermanent;
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
city=resultSet.getString("city").trim();
pw.println("<tr>");
pw.println("<td align='right'>"+sno+"</td>");
pw.println("<td>"+firstName+" "+lastName+"</td>");
if(gender.equals("M"))
{
pw.println("<td align='center'><img src='/hr/images/male_icon.png'></td>");
}
else
{
pw.println("<td align='center'><img src='/hr/images/female_icon.png'></td>");
}
if(isPermanent.equals("Y"))
{
pw.println("<td align='center'><img src='/hr/images/checked_icon.png'></td>");
}
else
{
pw.println("<td align='center'><img src='/hr/images/unchecked_icon.png'></td>");
}
pw.println("<td>"+city+"</td>");

pw.println("<td align='center'>");
pw.println("<a href=\"javascript:editEmployee("+code+")\"><img src='/hr/images/edit_icon.png'></a>");
//'/hr/editEmployee' (if we think that we can directly calll editEmployee servlet then we wrong becuse we ca call servlet but how we send a queryString and if no 
//querystrig then how we send the code of employee whose data is to be edit)
//\"javascript:editEmployee("+code+")\"
pw.println("</td>");


\ \ kese lagana he 
phla wala string chalu hone se phle 
dusra wala string khtm hone se phle

pw.println("<td align='center'>");
pw.println("<a href=\"javascript:deleteEmployee('"+firstName+" "+lastName+"',"+code+")\"><img src='/hr/images/delete_icon.png'></a>");
pw.println("</td>");

pw.println("</tr>");
}while(resultSet.next());
}
resultSet.close();
statement.close();
connection.close();
pw.println("</tbody>");
pw.println("</table>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");


//form get submitted when user clicks ok in delete confirm box ,and action taken
pw.println("<form id='employeeDeleteForm' action='/hr/deleteEmployee'>");
pw.println("<input type='hidden' name='code' id='code'>");
pw.println("</form>");
//else no action taken


//form get submitted when editEmployee() function get called ,and action taken(request goes for editEmployee servlet)
//so create editEmployeeServlet and process the code and send a filled form in response.
//map the servlet EditEmployee against url /editEmployee in web.xml
pw.println("<form id='employeeEditForm' action='/hr/editEmployee'>");
pw.println("<input type='hidden' name='code' id='code'>");
pw.println("</form>");
//else no action taken

pw.println("</body>");
pw.println("</html>");
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