package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public interface ThreadDetailsDTOInterface extends Serializable,Comparable<ThreadDetailsDTOInterface>
{ 
public void setThreadHeading(String threadHeading);
public String getThreadHeading();

public void setThreadCreatedDate(Timestamp threadCreatedDate);
public Timestamp getThreadCreatedDate();
  
public void setThreadImage(String threadImage);
public String getThreadImage();

public void setThreadContent(String threadContent);
public String getThreadContent();

public void setUserName(String userName);
public String getUserName();

public void setUserProfile(String userProfile);
public String getUserProfile();

public void setEmail(String email);
public String getEmail();

public void setCity(String city);
public String getCity();

public void setAge(int age);
public int getAge();

public void setDesignation(String designation);
public String getDesignation();

}