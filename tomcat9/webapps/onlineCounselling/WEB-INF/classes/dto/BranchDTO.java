package dto;
public class BranchDTO
{
private int code;
private String name;
private String fullName;
private int streamCode;
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

public void setFullName(String fullName)
{
this.fullName=fullName;
}
public String getFullName()
{
return this.fullName;
}
public void setStreamCode(int streamCode)
{
this.streamCode=streamCode;
}
public int getStreamCode()
{
return this.streamCode;
}
}