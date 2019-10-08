package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public class ThreadCommentDetailsDTO implements ThreadCommentDetailsDTOInterface
{   
  
  private int threadCommentId;
  private String threadCommentContent;
  private Timestamp threadCommentCreatedDate;
  private String userName;
  private String userProfile;
  private String email;
  private String city;
  private int age;
  private String designation;

  public ThreadCommentDetailsDTO()
  {
    this.threadCommentId=0;
    this.threadCommentContent=null;
    this.threadCommentCreatedDate=null;
    this.userName=null;
    this.userProfile=null;
    this.email=null;
    this.city=null;
    this.age=0;
    this.designation=null;       
     
  }


public void setThreadCommentId(int threadCommentId)
{
this.threadCommentId=threadCommentId;
}
public int getThreadCommentId()
{
return this.threadCommentId;
}
public void setThreadCommentContent(String threadCommentContent)
{
this.threadCommentContent=threadCommentContent;
} 
public String getThreadCommentContent()
{
return this.threadCommentContent;
}
public void setThreadCommentCreatedDate(Timestamp threadCommentCreatedDate)
{
this.threadCommentCreatedDate=threadCommentCreatedDate;
} 
public Timestamp getThreadCommentCreatedDate()
{
return this.threadCommentCreatedDate;
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
public int compareTo(ThreadCommentDetailsDTOInterface other)
{
return 0;
}
public int hashCode()
{
return 0;
}





    
}