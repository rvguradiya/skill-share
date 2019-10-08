package com.thinking.machines.hr.dl;
import java.io.*;
public interface EmployeeDTOInterface extends Serializable,Comparable<EmployeeDTOInterface>
{
public void setCode(int code);
public int getCode();
public void setFirstName(String firstName);
public String getFirstName();
public void setLastName(String lastName);
public String getLastName();
public void setGender(String gender);
public String getGender();
public void setIsPermanent(String isPermanent);
public String getIsPermanent();
public void setCity(String city);
public String getCity();
}
