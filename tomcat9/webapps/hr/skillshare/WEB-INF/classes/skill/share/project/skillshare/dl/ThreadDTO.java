package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public class ThreadDTO implements ThreadDTOInterface 
{
private int code;
private String subject;
private String heading;
private String content;
private String link;
private String imagePath;
private String type;
private int userId;
private Timestamp time;

public ThreadDTO()
{
this.code=0;
this.subject=null;
this.heading=null;
this.content=null;
this.link=null;
this.imagePath=null;
this.type=null;
this.userId=0;
this.time=null;
}

public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setSubject(String subject)
{
this.subject=subject;
}

public String getSubject()
{
return this.subject;
}
public void setHeading(String heading)
{
this.heading=heading;
}
public String getHeading()
{
return this.heading;

}
public void setContent(String content)
{
this.content=content;
}
public String getContent()
{
return this.content;
}
public void setLink(String link)
{
this.link=link;
}
public String getLink()
{
return this.link;
}
public void setImagePath(String imagePath)
{
this.imagePath=imagePath;
}
public  String getImagePath()
{
return this.imagePath;
}
public void setType(String type)
{
this.type=type;
}
public String getType()
{
return this.type;
}
public void setUserId(int userId)
{
this.userId=userId;
}
public int getUserId()
{
return this.userId;

}
public void setTime(Timestamp timeStamp)
{
this.time=time;
}
public Timestamp getTime()
{
return this.time;
}
public boolean equals(Object object)
{ if(object==null) return false;
if(!(object instanceof ThreadDTOInterface)) return false;
return this.code==((ThreadDTOInterface)object).getCode();
}
public int compareTo(ThreadDTOInterface other)
{
return this.code-other.getCode();
}
public int hashCode()
{
return code;
}
}
