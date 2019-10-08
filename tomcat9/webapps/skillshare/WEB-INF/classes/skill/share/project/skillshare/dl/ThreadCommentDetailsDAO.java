package skill.share.project.skillshare.dl;
import java.util.*;
import java.sql.*;
public class ThreadCommentDetailsDAO 
{
//ThreadCommentDetailsDTOInterface
public ArrayList<ThreadCommentDetailsDTOInterface> getThreadCommentDetails(int threadId) throws DAOException
{
ArrayList<ThreadCommentDetailsDTOInterface> threadComments=new ArrayList<ThreadCommentDetailsDTOInterface>();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from ((comment inner join user_account on comment.user_id=user_account.id)inner join user_profile on  user_account.id=user_profile.user_id) where comment.parent_id=? ORDER BY comment.created_at DESC");
preparedStatement.setInt(1,threadId);
ResultSet resultSet=preparedStatement.executeQuery();
ThreadCommentDetailsDTOInterface threadComment;
int i=0;
while(resultSet.next())
{
i++;
threadComment=new ThreadCommentDetailsDTO();
threadComment.setThreadCommentId(resultSet.getInt(1));
threadComment.setThreadCommentContent(resultSet.getString(2));
threadComment.setThreadCommentCreatedDate(resultSet.getTimestamp(3));
threadComment.setUserName(resultSet.getString(7));
threadComment.setUserProfile(resultSet.getString(14));
threadComment.setEmail(resultSet.getString(8));
threadComment.setCity(resultSet.getString(12));
threadComment.setAge(resultSet.getInt(13));
threadComment.setDesignation(resultSet.getString(15));
threadComments.add(threadComment);
}
System.out.println("total= "+i);
//we are not call trim() coz resultSet may return null values
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{ throw new DAOException(sqlException.getMessage());
}
return threadComments;
}
}