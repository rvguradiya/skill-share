package com.thinking.machines.hr;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class EditEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
//if user modifie url and do not send code then we have to return
//so code for thar scenario is below
String code=request.getParameter("code");
if(code==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/getEmployees");
requestDispatcher.forward(request,response);
return;
}
//if code!=null means kuch to aaya 











//now preapare the document by writing html code to it
PrintWriter pw=response.getWriter();
response.setContentType("Text/html");//Mime type set by us
pw.println("<!doctype html>");
pw.println("<html lang='en'>"); //en means english language
pw.println("<head>");
pw.println("<meta charset='utf-8'>");//to tell browser that it is html5 code
pw.println("<title>whatever</title>");
//the above code is copied as it is from GetEmployee.java file


//the below code of function ramu() to validate EditEmpoyeeForm is copied as   it is from EmployeeAddForm.html 
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
pw.println("genderErrorSection.innerHTML='Required';");   //out me " "  to inside ' ' lena hoga  inside bhi " " le liya to errror aayegi
pw.println("valid=false;");
pw.println("}");
pw.println("if(city.length==0)");
pw.println("{");
pw.println("cityErrorSection.innerHTML='Required';");
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
//the above code is to validate data of EditEmployee Form
//when this form is submitted the request goes to updateEmployeeServlet

//Connection connection=DAOConnection.getConnection();
//Statement statement;
//statement=connection.createStatement();
//ResultSet resultSet;
//resultSet=statement.executeQuery("select * from employee order by first_name,last_name");



//now extract data of code which comes in request from database 
//the below is the code to exatract the data
//the below code to extract data from database and preapre a html form(EditEmployee)
//and fill data in it
// and write it to document using printwriter



Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where code=?");
preparedStatement.setInt(1,Integer.parseInt(code));
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
resultSet.next();
int cd;
String firstName;
String lastName;
String gender;
String isPermanent;
String city;
cd=resultSet.getInt("code");
firstName=resultSet.getString("first_name").trim();
lastName=resultSet.getString("last_name").trim();
gender=resultSet.getString("gender");
isPermanent=resultSet.getString("is_permanent");
city=resultSet.getString("city").trim();
resultSet.close();
preparedStatement.close();
connection.close();





//////////////////////////////////code to create EditEmployee form starts......////// when this form get submitted request goes to updateEmployee servlet
pw.println("<body>");
pw.println("<h1>Employee (Edit Module)</h1>");
//pw.println("<h3 style='color:red'>"+firstName+" "+lastName+" exists</h3>");
//the above line is sent in response of updateEmployee servlet in case of if(found)
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
//////////////////////////////////code to create form ends
































//RequestDispatcher requestDispatcher;
//requestDispatcher=request.getRequestDispatcher("/getEmployees");
//requestDispatcher.forward(request,response);
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



