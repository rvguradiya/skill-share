package request;
import java.util.*;
import java.io.*;
import dto.*;
//this class is used to parse the  json array into corrosponding dto array
public class CountryRequest implements Serializable
{
private List<CountryDTO> countries;
public List<CountryDTO> getCountries()
{
return this.countries;
}
}