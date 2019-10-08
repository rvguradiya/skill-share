package skill.share.project.skillshare.dl;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public class CommentDTO implements CommentDTOInterface 
{
private int id;
private String content;
private int parentId;
private int userId;
private Timestamp time;

public CommentDTO()
{
this.id=0;
this.content=null;
this.parentId=0;
this.userId=0;
this.time=null;
}

public void setId(int id)
{
this.id=id;
}
public int getId()
{
return this.id;
}

public void setContent(String content)
{
this.content=content;
}
public String getContent()
{
return this.content;
}

public void setParentId(int parentId)
{
this.parentId=parentId;
}
public int getParentId()
{
return this.parentId;

}

public void setUserId(int userId)
{
this.userId=userId;
}
public int getUserId()
{
return this.userId;
}
public void setTime(Timestamp time)
{
this.time=time;
}
public  Timestamp getTime()
{
return this.time;
}


public boolean equals(Object object)
{ if(object==null) return false;
if(!(object instanceof CommentDTOInterface)) return false;
return this.id==((CommentDTOInterface)object).getId();
}
public int compareTo(CommentDTOInterface other)
{
return this.id-other.getId();
}
public int hashCode()
{
return id;
}


}
