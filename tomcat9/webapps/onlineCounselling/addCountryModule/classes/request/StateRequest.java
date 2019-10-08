package request;
import java.util.*;
import java.io.*;
import dto.*;
//we take pointer of list because it can hold the address of both linkedlist as well as arraylist
//this class is used to parse the  json array into corrosponding dto array

public class StateRequest implements Serializable
{
private List<StateDTO> states;
private int countryCode;
//insert data into country state mapping table as well as state table
//but no need of mapping here we take country code in state table
//the name in json must be as it is as here
public int getCountryCode()
{
return this.countryCode;
}
public List<StateDTO> getStates()
{
return this.states;
}
}