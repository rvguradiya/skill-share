package request;
import java.util.*;
import java.io.*;
import dto.*;
//we take pointer of list because it can hold the address of both linkedlist as well as arraylist
//this class is used to parse the  json array into corrosponding dto array

public class CityRequest implements Serializable
{
private List<CityDTO> cities;
private int stateCode;
//we have no need of country code here 
//we mention country dropdown in addCity form to faciliate user only
//we recieive stateCode because we have have to enter it in city table
//but we dont need country code here
//the name in json must be as it is as here
public int getStateCode()
{
return this.stateCode;
}
public List<CityDTO> getCities()
{
return this.cities;
}

}