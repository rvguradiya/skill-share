package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public interface CommentDTOInterface extends Serializable,Comparable<CommentDTOInterface>
{
public void setId(int id);
public int getId();

public void setContent(String content);
public String getContent();

public void setTime(Timestamp time);
public  Timestamp getTime();

public void setParentId(int id);
public int getParentId();

public void setUserId(int id);
public int getUserId();


}
