package skill.share.project.skillshare.dl;
import java.util.*;
import java.sql.*;
public class ThreadDetailsDAO 
{
//ThreadDTOInterface
public ThreadDetailsDTOInterface getThreadDetails(int threadId) throws DAOException
{
ThreadDetailsDTOInterface thread=null;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from ((thread inner join user_account on thread.user_id=user_account.id)inner join user_profile on  user_account.id=user_profile.user_id) where thread.id=?");
preparedStatement.setInt(1,threadId);
ResultSet resultSet=preparedStatement.executeQuery();
resultSet.next();
thread =new ThreadDetailsDTO(); 
thread.setThreadHeading(resultSet.getString(3));
thread.setThreadCreatedDate(resultSet.getTimestamp(8));
thread.setThreadImage(resultSet.getString(6));
thread.setThreadContent(resultSet.getString(4));
thread.setUserName(resultSet.getString(11));
thread.setUserProfile(resultSet.getString(18));
thread.setEmail(resultSet.getString(12));
thread.setCity(resultSet.getString(16));
thread.setAge(resultSet.getInt(17));
thread.setDesignation(resultSet.getString(19));
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{ throw new DAOException(sqlException.getMessage());
}
return thread;
}
}