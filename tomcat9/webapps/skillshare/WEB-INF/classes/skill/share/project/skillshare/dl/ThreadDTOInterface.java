package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public interface ThreadDTOInterface extends Serializable,Comparable<ThreadDTOInterface>
{
public void setCode(int code);
public int getCode();
public void setSubject(String subject);
public String getSubject();
public void setHeading(String heading);
public String getHeading();
public void setContent(String content);
public String getContent();
public void setLink(String link);
public String getLink();
public void setImagePath(String imagePath);
public  String getImagePath();
public void setType(String type);
public String getType();
public void setUserId(int id);
public int getUserId();
public void setTime(Timestamp timeStamp);
public Timestamp getTime();
}
