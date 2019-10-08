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
//similarly map and list of all dto's
//list is for sending the data when getAll(() is called
//map for checking the existance of data in table  while adding the data into table

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
servletContext.setAttribute("stateMap",stateMap);
servletContext.setAttribute("cities",cities);
servletContext.setAttribute("cityMap",cityMap);
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