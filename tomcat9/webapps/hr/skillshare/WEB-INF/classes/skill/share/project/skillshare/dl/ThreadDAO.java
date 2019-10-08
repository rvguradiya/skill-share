 package skill.share.project.skillshare.dl;
import java.util.*;
import java.sql.*;
public class ThreadDAO implements ThreadDAOInterface
{
public void add(ThreadDTOInterface threadDTOInterface) throws DAOException
{
try
{
System.out.println("this is id"+threadDTOInterface.getUserId());


Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("insert into thread(subject,heading,content,link,image_path,type,user_id) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,threadDTOInterface.getSubject());
preparedStatement.setString(2,threadDTOInterface.getHeading());
preparedStatement.setString(3,threadDTOInterface.getContent());
preparedStatement.setString(4,threadDTOInterface.getLink());
preparedStatement.setString(5,threadDTOInterface.getImagePath());
preparedStatement.setString(6,threadDTOInterface.getType());
preparedStatement.setInt(7,threadDTOInterface.getUserId());
preparedStatement.executeUpdate();
ResultSet resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
threadDTOInterface.setCode(resultSet.getInt(1));
//write code to get generated time also and set it into threadDTO so we can dispath it to ui
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}


public void update(ThreadDTOInterface thread) throws DAOException
{
throw new DAOException("Not yet implemented");
}
public void delete(int code) throws DAOException
{
}
/* write later
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from thread where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid code : "+code);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from thread where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
*/
public ArrayList<ThreadDTOInterface> getThreads() throws DAOException
{
ArrayList<ThreadDTOInterface> threads=new ArrayList<ThreadDTOInterface>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select * from thread");
ThreadDTOInterface thread;
while(resultSet.next())
{
thread=new ThreadDTO();
thread.setCode(resultSet.getInt("id"));
thread.setSubject(resultSet.getString("subject").trim());
thread.setHeading(resultSet.getString("heading").trim());
thread.setContent(resultSet.getString("content").trim());
thread.setLink(resultSet.getString("link").trim());
thread.setImagePath(resultSet.getString("image_path").trim());
thread.setType(resultSet.getString("type").trim());
thread.setUserId(resultSet.getInt("user_id"));
thread.setTime(resultSet.getTimestamp("time"));
threads.add(thread);
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return threads;
}

/*write later
public long getCount() throws DAOException
{
throw new DAOException("Not yet implemented");
}
*/
public ThreadDTOInterface getByCode(int code) throws DAOException
{
ThreadDTOInterface thread=new ThreadDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from thread where id=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
resultSet.next();
thread.setCode(resultSet.getInt("id"));
thread.setSubject(resultSet.getString("subject").trim());
thread.setHeading(resultSet.getString("heading").trim());
thread.setContent(resultSet.getString("content").trim());
thread.setLink(resultSet.getString("link").trim());
thread.setImagePath(resultSet.getString("image_path").trim());
thread.setType(resultSet.getString("type").trim());
thread.setUserId(resultSet.getInt("user_id"));
thread.setTime(resultSet.getTimestamp("time"));
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return thread;
}


}