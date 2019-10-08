package com.thinking.machines.hr.dl;
import java.util.*;
public interface EmployeeDAOInterface
{
public void add(EmployeeDTOInterface employee) throws DAOException;
public void update(EmployeeDTOInterface employee) throws DAOException;
public void delete(int code) throws DAOException;
public ArrayList<EmployeeDTOInterface> getEmployees() throws DAOException;
public long getCount() throws DAOException;
public EmployeeDTOInterface getByCode(int code) throws DAOException;
// many more methods
}
