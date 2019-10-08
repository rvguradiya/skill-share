package dto;
public class CampusDTO
{
private int code;
private String name;
private String address;
private int cityCode;
private int zipCode;
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}

public void setAddress(String address)
{
this.address=address;
}
public String getAddress()
{
return this.address;
}

public void setCityCode(int cityCode)
{
this.cityCode=cityCode;
}
public int getCityCode()
{
return this.cityCode;
}
public void setZipCode(int zipCode)
{
this.zipCode=zipCode;
}
public int getZipCode()
{
return this.zipCode;
}


}