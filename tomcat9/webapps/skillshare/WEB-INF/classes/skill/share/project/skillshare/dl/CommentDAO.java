package skill.share.project.skillshare.dl;
import java.util.*;
import java.sql.*;
public class CommentDAO implements CommentDAOInterface
{
public void add(CommentDTOInterface commentDTOInterface) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("insert into comment(content,parent_id,user_id) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,commentDTOInterface.getContent());
preparedStatement.setInt(2,commentDTOInterface.getParentId());
preparedStatement.setInt(3,commentDTOInterface.getUserId());
preparedStatement.executeUpdate();
ResultSet resultSet;
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
commentDTOInterface.setId(resultSet.getInt(1));
resultSet.close();
preparedStatement.close();
//Statement statement=connection.createStatement();
//resultSet=statement.executeQuery("select * from comment where id=?");

preparedStatement=connection.prepareStatement("select * from comment where id=?");
preparedStatement.setInt(1,commentDTOInterface.getId());
resultSet=preparedStatement.executeQuery();
resultSet.next();
commentDTOInterface.setTime(resultSet.getTimestamp(3));
//write code to get generated time also and set it into CommentDTO so we can dipath it to ui
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("sqlException");
throw new DAOException(sqlException.getMessage());
}
}

/* write later
public void update(CommentDTOInterface Comment) throws DAOException
{
throw new DAOException("Not yet implemented");
}
public void delete(int id) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select id from Comment where id=?");
preparedStatement.setInt(1,id);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid id : "+id);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from Comment where id=?");
preparedStatement.setInt(1,id);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
*/
public ArrayList<CommentDTOInterface> getComments(int parentId) throws DAOException
{
ArrayList<CommentDTOInterface> comments=new ArrayList<CommentDTOInterface>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
PreparedStatement preparedStatement=connection.prepareStatement("select * from comment where parent_id=? ORDER BY created_at DESC");
preparedStatement.setInt(1,parentId);
ResultSet resultSet=preparedStatement.executeQuery();
CommentDTOInterface comment=null;
while(resultSet.next())
{
comment=new CommentDTO();
comment.setId(resultSet.getInt("id"));
comment.setContent(resultSet.getString("content").trim());
comment.setParentId(resultSet.getInt("parent_id"));
comment.setUserId(resultSet.getInt("user_id"));
comment.setTime(resultSet.getTimestamp("created_at"));
comments.add(comment);
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return comments;
}

/*write later
public long getCount() throws DAOException
{
throw new DAOException("Not yet implemented");
}

public CommentDTOInterface getByCode(int id) throws DAOException
{
CommentDTOInterface Comment=new CommentDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from Comment where id=?");
preparedStatement.setInt(1,id);
ResultSet resultSet=preparedStatement.executeQuery();
resultSet.next();
Comment.setId(resultSet.getInt("id"));
Comment.setConent(resultSet.getString("content").trim());
Comment.setType(resultSet.getString("parent_id"));
Comment.setUserId(resultSet.getInt("user_id"));
Comment.setTime(resultSet.getTimeStamp("time"));
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return Comment;
}
*/

}//class ends