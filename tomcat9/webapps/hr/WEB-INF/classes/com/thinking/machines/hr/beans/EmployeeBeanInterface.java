package com.thinking.machines.hr.beans;
import java.io.*;
public interface EmployeeBeanInterface extends Serializable,Comparable<EmployeeBeanInterface>
{
public void setCode(int code);
public int getCode();
public void setFirstName(String firstName);
public String getFirstName();
public void setLastName(String lastName);
public String getLastName();
public void setGender(String gender);
public String getGender();
public void setIsPermanent(boolean isPermanent);
public boolean getIsPermanent();
public void setCity(String city);
public String getCity();
}