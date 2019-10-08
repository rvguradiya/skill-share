package com.thinking.machines.hr.beans;
import java.io.*;
public class EmployeeBean implements EmployeeBeanInterface
{
private int code;
private String firstName;
private String lastName;
private String gender;
private boolean isPermanent;
private String city;
public EmployeeBean()
{
this.code=0;
this.firstName=null;
this.lastName=null;
this.gender=null;
this.isPermanent=false;
this.city=null;
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code; }
public void setFirstName(String firstName) {
this.firstName=firstName; }
public String getFirstName() {
return this.firstName; }
public void setLastName(String lastName) {
this.lastName=lastName; }
public String getLastName() {
return this.lastName; }
public void setGender(String gender) {
this.gender=gender; }
public String getGender() {
return this.gender; }
public void setCity(String city) {
this.city=city; }
public String getCity() {
return this.city; }
public void setIsPermanent(boolean isPermanent) {
this.isPermanent=isPermanent; }
public boolean getIsPermanent() {
return this.isPermanent; }
public boolean equals(Object object) {
if(object==null) return false;
if(!(object instanceof EmployeeBeanInterface)) return false;
return this.code==((EmployeeBeanInterface)object).getCode();
}
public int compareTo(EmployeeBeanInterface other)
{
//return this.code-other.getCode();
if(this.firstName.equalsIgnoreCase(other.getFirstName())) return
this.lastName.toUpperCase().compareTo(other.getLastName().toUpperCase());
return this.firstName.toUpperCase().compareTo(other.getFirstName().toUpperCase());
}
public int hashCode()
{
return code;
}
}
