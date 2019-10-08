package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public class ThreadDetailsDTO implements ThreadDetailsDTOInterface
{   
  private String threadHeading;
  private Timestamp threadCreatedDate;
  private String threadImage;
  private String threadContent;
  private String userName;
  private String userProfile;
  private String email;
  private String city;
  private int age;
  private String designation;

  public ThreadDetailsDTO()
  {
    this.threadHeading=null;
    this.threadCreatedDate=null;
    this.threadImage=null;
    this.threadContent=null;
    this.userName=null;
    this.userProfile=null;
    this.email=null;
    this.city=null;
    this.age=0;
    this.designation=null;       
     
  }


public void setThreadHeading(String threadHeading)
{
this.threadHeading=threadHeading;
}
public String getThreadHeading()
{
return this.threadHeading;
}
public void setThreadCreatedDate(Timestamp threadCreatedDate)
{
this.threadCreatedDate=threadCreatedDate;
} 
public Timestamp getThreadCreatedDate()
{
return this.threadCreatedDate;
}
public void setThreadImage(String threadImage)
{
this.threadImage=threadImage;
} 
public String getThreadImage()
{
return this.threadImage;
}  
public void setThreadContent(String threadContent)
{
this.threadContent=threadContent;
} 
public String getThreadContent()
{
return this.threadContent;
}
public void setUserName(String userName)
{
this.userName=userName;
} 
public String getUserName()
{
return this.userName;
}
public void setUserProfile(String userProfile)
{
this.userProfile=userProfile;
} 
public String getUserProfile()
{
return this.userProfile;
}

public void setEmail(String email)
{
this.email=email;
} 
public String getEmail()
{
return this.email;
}

public void setCity(String city)
{
this.city=city;
} 
public String getCity()
{
return this.city;
}
public void setAge(int age)
{
this.age=age;
} 
public int getAge()
{
return this.age;
}        
public void setDesignation(String designation)
{
this.designation=designation;
} 
public String getDesignation()
{
return this.designation;
}        
    
public boolean equals(Object object)
{ 
return true;
}
public int compareTo(ThreadDetailsDTOInterface other)
{
return 0;
}
public int hashCode()
{
return 0;
}    
 }