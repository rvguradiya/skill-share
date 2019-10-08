package dto;
public class BranchSeatsDTO
{
private int code;
private int campusCode;
private int streamCode;
private int branchCode;
private int seats;
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setCampusCode(int campusCode)
{
this.campusCode=campusCode;
}
public int getCampusCode()
{
return this.campusCode;
}

public void setStreamCode(int streamCode)
{
this.streamCode=streamCode;
}
public int getStreamCode()
{
return this.streamCode;
}

public void setBranchCode(int branchCode)
{
this.branchCode=branchCode;
}
public int getBranchCode()
{
return this.branchCode;
}

public void setSeats(int seats)
{
this.seats=seats;
}
public int getSeats()
{
return this.seats;
}

}