/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.14
 * Generated at: 2019-06-07 07:45:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>admin panel</title>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "library.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminPanelHeader.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction addRow(tableID) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar table = document.getElementById(tableID);\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar rowCount = table.rows.length;\r\n");
      out.write("\t\t\tvar row = table.insertRow(rowCount);\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar colCount = table.rows[0].cells.length;\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor(var i=0; i<colCount; i++) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar newcell\t= row.insertCell(i);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tnewcell.innerHTML = table.rows[0].cells[i].innerHTML;\r\n");
      out.write("\t\t\t\t//alert(newcell.childNodes);\r\n");
      out.write("\t\t\t\tswitch(newcell.childNodes[0].type) {\r\n");
      out.write("\t\t\t\t\tcase \"text\":\r\n");
      out.write("\t\t\t\t\t\t\tnewcell.childNodes[0].value = \"\";\r\n");
      out.write("\t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\tcase \"checkbox\":\r\n");
      out.write("\t\t\t\t\t\t\tnewcell.childNodes[0].checked = false;\r\n");
      out.write("\t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction deleteRow(tableID) {\r\n");
      out.write("\t\t\ttry {\r\n");
      out.write("\t\t\tvar table = document.getElementById(tableID);\r\n");
      out.write("\t\t\tvar rowCount = table.rows.length;\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor(var i=0; i<rowCount; i++) {\r\n");
      out.write("\t\t\t\tvar row = table.rows[i];\r\n");
      out.write("\t\t\t\tvar chkbox = row.cells[0].childNodes[0];\r\n");
      out.write("\t\t\t\tif(null != chkbox && true == chkbox.checked) {\r\n");
      out.write("\t\t\t\t\tif(rowCount <= 1) {\r\n");
      out.write("\t\t\t\t\t\talert(\"Cannot delete all the rows.\");\r\n");
      out.write("\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttable.deleteRow(i);\r\n");
      out.write("\t\t\t\t\trowCount--;\r\n");
      out.write("\t\t\t\t\ti--;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t}catch(e) {\r\n");
      out.write("\t\t\t\talert(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addCampus\" style=\"display: none;border:1px solid black;margin-top: 10px\" class=\"col-sm-6 container\">\r\n");
      out.write("\t<form id=\"addCampusForm\">\r\n");
      out.write("\t\t<label><h3>Add Campus</h3></label><br>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<label>Name </label>\r\n");
      out.write("\t\t<input type=\"text\" name=\"campusName\" ><br>\r\n");
      out.write("\t\t<label>Address </label>\r\n");
      out.write("\t\t<input type=\"text\" name=\"address\" ><br>\r\n");
      out.write("\t\t<label>Country </label>\r\n");
      out.write("\t\t<select name=\"country\" id=\"addCampusFormCountryDropDown\"  onchange =\"javascript:getStateList(this.value,'addCampusFormStateDropDown')\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t</select><br>\r\n");
      out.write("\t\t<label>State </label>\r\n");
      out.write("\t\t<select  name=\"state\" id=\"addCampusFormStateDropDown\"  onchange =\"javascript:getCityList(this.value,'addCampusFormCityDropDown')\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t</select><br>\r\n");
      out.write("\t\t<label>City </label>\r\n");
      out.write("\t\t<select name=\"city\" id=\"addCampusFormCityDropDown\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t</select><br>\r\n");
      out.write("\t\t<label>Zip Code </label>\r\n");
      out.write("\t\t<input type=\"text\" name=\"zipCode\" required=\"\"><br><br>\r\n");
      out.write("\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\"  onclick=\"javascript:addCampus('addCampusForm')\">Add\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addStreamFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("        <input type=\"reset\" name=\"\" style=\"visibility: hidden\" id=\"resetAddCampusForm\">\r\n");
      out.write("        </center>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addStream\" style=\"display: none;border:1px solid black;margin-top: 10px\" class=\"col-sm-6 container\">\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<label><h3>Add Stream</h3></label><br>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<input type=\"button\" value=\"Add Row\" onclick=\"addRow('addStreamTable')\" />\r\n");
      out.write("\t\t<input type=\"button\" value=\"Delete Row\" onclick=\"deleteRow('addStreamTable')\" />\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<table id=\"addStreamTable\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type='checkbox' name='chk'/></td>\r\n");
      out.write("\t\t\t\t\t<td><label>Stream </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='streamName'/></td>\r\n");
      out.write("\t\t\t\t\t<td><label>Full Name </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"fullName\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\"  onclick=\"addStream('addStreamTable')\">Add\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addStreamFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("         <input type=\"reset\" name=\"\" style=\"visibility: hidden\" id=\"resetAddStreamForm\">\r\n");
      out.write("        </center>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addBranch\" style=\"display:none;border:1px solid black;margin-top: 10px\" class=\"col-sm-8 container\">\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<label><h3>Add Branch</h3></label><br>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<label>Select Stream : </label>\r\n");
      out.write("\t\t\t<select name=\"state\" id=\"addBranchFormStreamDropDown\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t</select><br><br>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Add Row\" onclick=\"addRow('addBranchTable')\" />\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Delete Row\" onclick=\"deleteRow('addBranchTable')\" />\r\n");
      out.write("\t\t\t<table id=\"addBranchTable\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type='checkbox' name='chk'/></td>\r\n");
      out.write("\t\t\t\t\t<td><label style=\"margin-left: 15px\">Branch Name </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='branchName' /></td>\r\n");
      out.write("\t\t\t\t\t<td><label style=\"margin-left: 25px\">Full Name </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='fullName' /></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button type=\"button\"  class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\" onclick=\"javascript:addBranch('addBranchTable','addBranchFormStreamDropDown')\" >Add\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addBranchFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("         <input type=\"reset\" name=\"\" style=\"visibility: hidden\" id=\"resetAddBranchForm\">\r\n");
      out.write("        </center>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addBranchSeats\" style=\"display:none;border:1px solid black;margin-top: 10px\" class=\"col-sm-8 container\">\r\n");
      out.write("\t<center>\r\n");
      out.write("\t<form id=\"addBranchSeatsForm\">\r\n");
      out.write("\t\t\t<label><h3>Add Branch seats</h3></label><br>\r\n");
      out.write("\t\t\t<label>Select Campus : </label>\r\n");
      out.write("\t\t\t<select name=\"campus\" id=\"addBranchSeatsFormCampusDropDown\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</select><br>\r\n");
      out.write("\t\t\t<label>Select Stream : </label>\r\n");
      out.write("\t\t\t<select name=\"stream\" id=\"addBranchSeatsFormStreamDropDown\" onchange=\"javascript:getBranchSeatsForm('addBranchSeatsTableBody',this.value)\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</select><br><br>\r\n");
      out.write("\t\t\t<table  id=\"addBranchSeatsTable\" border=\"1px solid black\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label style=\"margin-left: 15px\">Branch Name </label></th>\r\n");
      out.write("\t\t\t\t\t\t<th><label style=\"margin-left: 25px\">Full Name </label></th>\r\n");
      out.write("\t\t\t\t\t\t<th><label style=\"margin-left: 25px\">No. of seats </label></th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"addBranchSeatsTableBody\" >\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--add row by fecthing all the branch of stream and give a text box in front of each row to enter the number of seats in this form user enters only no. of seats while branch name is fecthed from database and shown in uneditable textbox-->\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\" onclick=\"javascript:addBranchSeats('addBranchSeatsForm','addBranchSeatsTableBody')\">Add\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addBranchSeatsFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("\t</form>\r\n");
      out.write("    </center>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addCity\" style=\"display:none;border:1px solid black;margin-top: 10px\" class=\"col-sm-6 container\">\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<label><h3>Add City</h3></label><br>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<label>Select Country : </label>\r\n");
      out.write("\t\t\t<select name=\"country\" id=\"addCityFormCountryDropDown\" onchange =\"javascript:getStateList(this.value,'addCityFormStateDropDown')\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t</select><br>\r\n");
      out.write("\t\t\t<label>Select State : </label>\r\n");
      out.write("\t\t\t<select name=\"state\" id=\"addCityFormStateDropDown\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</select><br><br>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Add Row\" onclick=\"addRow('addCityTable')\" />\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Delete Row\" onclick=\"deleteRow('addCityTable')\" />\r\n");
      out.write("\t\t\t<table id=\"addCityTable\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type='checkbox' name='chk'/></td>\r\n");
      out.write("\t\t\t\t\t<td><label>City Name </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='cityName'/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\"  onclick=\"javascript:addCity('addCityTable','addCityFormStateDropDown')\">Add\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addCityFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("        <input type=\"reset\" name=\"\" style=\"visibility: hidden\" id=\"resetAddCityForm\">\r\n");
      out.write("        </center>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addState\" style=\"display:none;border:1px solid black;margin-top: 10px\" class=\"col-sm-6 container\">\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<label><h3>Add State</h3></label><br>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<label>Select Country : </label>\r\n");
      out.write("\t\t\t<select name=\"country\" id=\"addStateFormCountryDropDown\">\r\n");
      out.write("\t\t\t\t\t<OPTION value=0>Select</OPTION>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</select><br><br>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Add Row\" onclick=\"addRow('addStateTable')\" />\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Delete Row\" onclick=\"deleteRow('addStateTable')\" />\r\n");
      out.write("\t\t\t<table id=\"addStateTable\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type='checkbox' name='chk'/></td>\r\n");
      out.write("\t\t\t\t\t<td><label>State Name </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='stateName'/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\"  onclick=\"javascript:addState('addStateTable','addStateFormCountryDropDown')\">Add State\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addStateFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("        <input type=\"reset\" name=\"\" style=\"visibility: hidden\" id=\"resetAddStateForm\">\r\n");
      out.write("        </center>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"addCountry\" style=\"display: none;border:1px solid black;margin-top: 10px\" class=\"col-sm-6 container\">\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<label><h3>Add Country</h3></label><br>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<input type=\"button\" value=\"Add Row\" onclick=\"addRow('addCountryTable')\" />\r\n");
      out.write("\t\t<input type=\"button\" value=\"Delete Row\" onclick=\"deleteRow('addCountryTable')\" />\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<table id=\"addCountryTable\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type='checkbox' name='chk'/></td>\r\n");
      out.write("\t\t\t\t\t<td><label>Country Name </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='countryName'/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 15px;margin-left: 15px;letter-spacing: 1px ;width: 45%;display:inline-block;\" onclick=\"javascript:addCountry('addCountryTable')\">Add Country\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"margin-top: 10px;margin-left: 15px;letter-spacing: 1px;width: 45%;\" onclick=\"javascript:addCountryFunction('none')\">Cancel\r\n");
      out.write("        </button>\r\n");
      out.write("         <input type=\"reset\" name=\"\" style=\"visibility: hidden\" id=\"resetAddCountryForm\">\r\n");
      out.write("        </center>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
