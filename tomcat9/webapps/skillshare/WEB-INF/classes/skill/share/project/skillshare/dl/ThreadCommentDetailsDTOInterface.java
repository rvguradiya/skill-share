package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public interface ThreadCommentDetailsDTOInterface extends Serializable,Comparable<ThreadCommentDetailsDTOInterface>
{ 
public void setThreadCommentId(int threadCommentId);
public int getThreadCommentId();

public void setThreadCommentContent(String threadCommentContent);
public String getThreadCommentContent();

public void setThreadCommentCreatedDate(Timestamp threadCommentCreatedDate);
public Timestamp getThreadCommentCreatedDate();

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