//we copy whole  code of addEmployee.java servlet here only query change.
package com.thinking.machines.hr;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UpdateEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
String code=request.getParameter("code");
String firstName=request.getParameter("firstName");
String lastName=request.getParameter("lastName");
String gender=request.getParameter("gender");
String isPermanent=request.getParameter("isPermanent");
String city=request.getParameter("city");
if(isPermanent==null) isPermanent="N";
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from employee where first_name=? and last_name=? and code<>?");
preparedStatement.setString(1,firstName);
preparedStatement.setString(2,lastName);
preparedStatement.setInt(3,Integer.parseInt(request.getParameter("code")));
ResultSet resultSet=preparedStatement.executeQuery();
boolean found=resultSet.next();
resultSet.close();
preparedStatement.close();
if(found)
{
pw.println("<!doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Some company name</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var firstNameComponent=frm.firstName;");
pw.println("var lastNameComponent=frm.lastName;");
pw.println("var maleComponent=frm.gender[0];");
pw.println("var femaleComponent=frm.gender[1];");
pw.println("var isPermanentComponent=frm.isPermanent;");
pw.println("var cityComponent=frm.city;");
pw.println("var firstNameErrorSection=document.getElementById('firstNameErrorSection');");
pw.println("var lastNameErrorSection=document.getElementById('lastNameErrorSection');");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("var cityErrorSection=document.getElementById('cityErrorSection');");
pw.println("var firstName=firstNameComponent.value.trim();");
pw.println("var lastName=lastNameComponent.value.trim();");
pw.println("var city=cityComponent.value.trim();");
pw.println("var valid=true;");
pw.println("firstNameErrorSection.innerHTML='';");
pw.println("lastNameErrorSection.innerHTML='';");
pw.println("genderErrorSection.innerHTML='';");
pw.println("cityErrorSection.innerHTML='';");
pw.println("var firstInvalidComponent=null;");
pw.println("if(firstName.length==0)");
pw.println("{");
pw.println("firstNameErrorSection.innerHTML='Required';");
pw.println("valid=false;");
pw.println("firstInvalidComponent=firstNameComponent;");
pw.println("}");
pw.println("if(lastName.length==0)");
pw.println("{");
pw.println("lastNameErrorSection.innerHTML='Required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=lastNameComponent;");
pw.println("}");
pw.println("if(male.checked==false && female.checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML=\"Required\";");
pw.println("valid=false;");
pw.println("}");
pw.println("if(city.length==0)");
pw.println("{");
pw.println("cityErrorSection.innerHTML=\"Required\";");
pw.println("if(valid==true) firstInvalidComponent=cityComponent;");
pw.println("valid=false;");
pw.println("}");
pw.println("if(valid==false && firstInvalidComponent!=null)");
pw.println("{");
pw.println("firstInvalidComponent.focus();");
pw.println("}");
pw.println("return valid;");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h1>Employee (Edit Module)</h1>");
pw.println("<h3 style='color:red'>"+firstName+" "+lastName+" exists</h3>");
pw.println("<form method='get' action='/hr/updateEmployee' onsubmit='return validateForm(this)'>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>First name</td>");
pw.println("<td>");
pw.println("<input type='text' name='firstName' id='firstName' maxlength='20' size='21' value='"+firstName+"'>");
pw.println("<span id='firstNameErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Last name</td>");
pw.println("<td>");
pw.println("<input type='text' name='lastName' id='lastName' maxlength='20' size='21' value='"+lastName+"'>");
pw.println("<span id='lastNameErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Gender</td>");
if(gender.equals("M"))
{
pw.println("<td>Male <input type='radio' checked name='gender' id='male' value='M'>&nbsp;&nbsp;&nbsp;Female<input type='radio' name='gender' id='female' value='F'>");
}
else
{
pw.println("<td>Male <input type='radio' name='gender' id='male' value='M'>&nbsp;&nbsp;&nbsp;Female<input type='radio' name='gender' checked id='female' value='F'>");
}
pw.println("<span id='genderErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Is Permanent</td>");
if(isPermanent.equals("Y"))
{
pw.println("<td><input type='checkbox' name='isPermanent' checked id='isPermanent' value='Y'></td>");
}
else
{
pw.println("<td><input type='checkbox' name='isPermanent' id='isPermanent' value='Y'></td>");
}
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>City</td>");
pw.println("<td><input type='text' name='city' id='city' maxlength='35' size='36' value='"+city+"'>");
pw.println("<span id='cityErrorSection' style='color:red'></span></td>");
pw.println("</tr>");

//we also create a hidden field for code because we have to forward the code comes in request  to update employee when user clicks update
pw.println("<tr>");
pw.println("<input type='hidden' name='code' id='code' value='"+code+"'>");
pw.println("</tr>");


pw.println("<tr>");
pw.println("<td colspan='3' align='center'>");
pw.println("<button type='submit'>Update</button>");
pw.println("</td>");
pw.println("</table>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
connection.close();
return;
}
preparedStatement=connection.prepareStatement("update employee set first_name=?,last_name=?,gender=?,is_permanent=?,city=?  where code=?");
preparedStatement.setString(1,firstName);
preparedStatement.setString(2,lastName);
preparedStatement.setString(3,gender);
preparedStatement.setString(4,isPermanent);
preparedStatement.setString(5,city);
preparedStatement.setInt(6,Integer.parseInt(request.getParameter("code")));
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
pw.println("<!doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Some company name</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("Employee Updated<br>");
pw.println("<form action='/hr/getEmployees'>");
pw.println("<button>Ok</button>");
pw.println("</form>");
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