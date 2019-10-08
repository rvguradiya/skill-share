import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

import dl.*;
import dto.*;
import request.*;
import response.*;

public class StartupService extends HttpServlet
{
public void init()
{
System.out.println("************************************");
System.out.println("************************************");
System.out.println("***Populating Data Structures***");
System.out.println("************************************");
System.out.println("************************************");
System.out.println("************************************");
System.out.println("************************************");
LinkedList<CountryDTO> countries=new LinkedList<>();
HashMap<String,CountryDTO> countryMap=new HashMap<>();
LinkedList<StateDTO> states=new LinkedList<>();
HashMap<String,StateDTO> stateMap=new HashMap<>();
LinkedList<CityDTO> cities=new LinkedList<>();
HashMap<String,CityDTO> cityMap=new HashMap<>();
LinkedList<CampusDTO> campuses=new LinkedList<>();
HashMap<String,CampusDTO> campusMap=new HashMap<>();
LinkedList<StreamDTO> streams=new LinkedList<>();
HashMap<String,StreamDTO> streamMap=new HashMap<>();
LinkedList<BranchDTO> branches=new LinkedList<>();
HashMap<String,BranchDTO> branchMap=new HashMap<>();
//similarly map and list of all dto's
//list is for sending the data when getAll(() is called
//map for checking the existance of data in table  while adding the data into table
//we create only map for mapping tables....because we dont need to return list ....we have to only check uniqueness  of 
//combination of primary key [primary key constraints] before inserting into table.
//we convert int to string for making combination of key
HashSet<String> streamBranchSet=new HashSet<>();
HashSet<String> campusStreamSet=new HashSet<>();
HashSet<String> campusStreamBranchSet=new HashSet<>();
try
{
Connection connection=DAOConnection.getConnection();
//System.out.println("connection: "+connection); 

/************populate data from country table********/
Statement statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
ResultSet resultSet=statement.executeQuery("select * from country");
CountryDTO country;
while(resultSet.next())
{
country=new CountryDTO();
country.setCode(resultSet.getInt("code"));
country.setName(resultSet.getString("name").trim());
countries.add(country);
countryMap.put(country.getName().toUpperCase(),country);
}
resultSet.close();
statement.close();
System.out.println("country******************");
/************populate data from country table ends********/


/************populate data from state table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from state");
StateDTO state;
while(resultSet.next())
{
state=new StateDTO();
state.setCode(resultSet.getInt("code"));
state.setName(resultSet.getString("name").trim());
state.setCountryCode(resultSet.getInt("country_code"));
states.add(state);
stateMap.put(state.getName().toUpperCase(),state);
}
resultSet.close();
statement.close();
System.out.println("state******************");
/************populate data from state table ends********/



/************populate data from city table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from city");
CityDTO city;
while(resultSet.next())
{
city=new CityDTO();
city.setCode(resultSet.getInt("code"));
city.setName(resultSet.getString("name").trim());
city.setStateCode(resultSet.getInt("state_code"));
cities.add(city);
cityMap.put(city.getName().toUpperCase(),city);
}
resultSet.close();
statement.close();
System.out.println("city******************");
/************populate data from city table ends********/


/************populate data from campus table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from campus");
CampusDTO campus;
while(resultSet.next())
{
campus=new CampusDTO();
campus.setCode(resultSet.getInt("code"));
campus.setName(resultSet.getString("name").trim());
campus.setAddress(resultSet.getString("address").trim());
campus.setCityCode(resultSet.getInt("city_code"));
campus.setZipCode(resultSet.getInt("zip_code"));
campuses.add(campus);
campusMap.put(campus.getName().toUpperCase(),campus);
}
resultSet.close();
statement.close();
System.out.println("campus******************");
/************populate data from campus table ends********/



/************populate data from stream table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from stream");

StreamDTO stream;
while(resultSet.next())
{
stream=new StreamDTO();
stream.setCode(resultSet.getInt("code"));
stream.setName(resultSet.getString("name").trim());
stream.setFullName(resultSet.getString("full_name").trim());
streams.add(stream);
streamMap.put(stream.getName().toUpperCase()+" "+stream.getFullName().toUpperCase(),stream);
}
resultSet.close();
statement.close();
System.out.println("stream******************");
/************populate data from stream table ends********/




/************populate data from branch table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from ( branch inner join stream_branch on branch.code=stream_branch.branch_code)");

BranchDTO branch;
while(resultSet.next())
{
branch=new BranchDTO();
branch.setCode(resultSet.getInt("code"));
branch.setName(resultSet.getString("name").trim());
branch.setFullName(resultSet.getString("full_name").trim());
branch.setStreamCode(resultSet.getInt("stream_code"));
branches.add(branch);
branchMap.put(branch.getName().toUpperCase(),branch);
branchMap.put(branch.getFullName().toUpperCase(),branch);
//if more then one unique key in table then we have to put each key in the map 
//here idea combination of key and put in map is failed because unique key in table is not combination ...instead each column
//represent a unique key so we have to put each unique key in map
//instead we have to take set for checking the primary key not a map 
//but map is required when want to return single dto based on primary key.
//e.g. getByName(name+fullname){if(map.containsKey(branch.getName().toUpperCase()&&branch.getFullName().toUpperCase()) return map.get(branch.getName().toUpperCase())}
//means if more then unique field in table then we have to put each field in map ............put dto in one key and put null in all other key
}
resultSet.close();
statement.close();
System.out.println("branch******************");
/************populate data from branch table ends********/



/************populate data from campus stream table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from campus_stream");
String a,b;
while(resultSet.next())
{
a=Integer.toString(resultSet.getInt("campus_code"));
b=Integer.toString(resultSet.getInt("stream_code"));
campusStreamSet.add(a+" "+b);
}
resultSet.close();
statement.close();
System.out.println("campus stream******************");
/************populate data from campus stream  table ends********/





/************populate data from stream branch table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from stream_branch");
while(resultSet.next())
{
a=Integer.toString(resultSet.getInt("stream_code"));
b=Integer.toString(resultSet.getInt("branch_code"));
streamBranchSet.add(a+" "+b);
}
resultSet.close();
statement.close();
System.out.println(" stream branch******************");
/************populate data from stream branch table ends********/



/************populate data from campus stream branch table********/
statement=connection.createStatement();//nullpointer exception raised here if database server is not started and DAOConnection() return null
resultSet=statement.executeQuery("select * from campus_stream_branch");
String c;
while(resultSet.next())
{
a=Integer.toString(resultSet.getInt("campus_code"));
b=Integer.toString(resultSet.getInt("stream_code"));
c=Integer.toString(resultSet.getInt("branch_code"));
campusStreamBranchSet.add(a+" "+b+" "+c);
}
resultSet.close();
statement.close();
System.out.println("campus stream branch******************");
/************populate data from campus stream branch table ends********/


connection.close();
}catch(SQLException se)
{
System.out.println("sql exception occurs while populating countries from database: "+se);
}
catch(Exception e)
{
System.out.println("exception occurs while populating countries from database: "+e);
}
ServletContext servletContext=getServletContext();

servletContext.setAttribute("countries",countries);
servletContext.setAttribute("countriesMap",countryMap);
servletContext.setAttribute("states",states);
servletContext.setAttribute("statesMap",stateMap);
servletContext.setAttribute("cities",cities);
servletContext.setAttribute("citiesMap",cityMap);
servletContext.setAttribute("campuses",campuses);
servletContext.setAttribute("campusesMap",campusMap);
servletContext.setAttribute("streams",streams);
servletContext.setAttribute("streamsMap",streamMap);
servletContext.setAttribute("branches",branches);
servletContext.setAttribute("branchesMap",branchMap);
servletContext.setAttribute("campusStreamSet",campusStreamSet);
servletContext.setAttribute("streamBranchSet",streamBranchSet);
servletContext.setAttribute("campusStreamBranchSet",campusStreamBranchSet);
System.out.println("ends******************");
/*
System.out.println(countries);
System.out.println(countryMap);
System.out.println(states);
System.out.println(stateMap);
System.out.println(cities);
System.out.println(cityMap);
*/
}
}