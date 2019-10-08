package com.thinking.machines.hr.dl;
import java.io.*;
public class EmployeeDTO implements EmployeeDTOInterface
{
private int code;
private String firstName;
private String lastName;
private String gender;
private String isPermanent;
private String city;
public EmployeeDTO()
{ this.code=0;
this.firstName=null;
this.lastName=null;
this.gender=null;
this.isPermanent=null;
this.city=null;
}

public void setCode(int code)
{ this.code=code;
}
public int getCode()
{
return this.code;
}
public void setFirstName(String firstName)
{ this.firstName=firstName;
}
public String getFirstName()
{
return this.firstName;
}
public void setLastName(String lastName)
{ this.lastName=lastName;
}
public String getLastName()
{
return this.lastName;
}
public void setGender(String gender)
{ this.gender=gender;
}
public String getGender()
{
return this.gender;
}
public void setCity(String city)
{ this.city=city;
}
public String getCity()
{
return this.city;
}
public void setIsPermanent(String isPermanent)
{ this.isPermanent=isPermanent;
}
public String getIsPermanent()
{
return this.isPermanent;

}
public boolean equals(Object object)
{ if(object==null) return false;
if(!(object instanceof EmployeeDTOInterface)) return false;
return this.code==((EmployeeDTOInterface)object).getCode();
}
public int compareTo(EmployeeDTOInterface other)
{
return this.code-other.getCode();
}
public int hashCode()
{
return code;
}}