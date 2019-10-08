package skill.share.project.skillshare.dl;
import java.util.*;
public interface CommentDAOInterface
{
public void add(CommentDTOInterface comment) throws DAOException;
//public void update(CommentDTOInterface comment) throws DAOException;
//public void delete(int id) throws DAOException;
public ArrayList<CommentDTOInterface> getComments(int parentId) throws DAOException;
//public CommentDTOInterface getCommentById() throws DAOException;
//public long getCount() throws DAOException;
//public EmployeeDTOInterface getByCode(int id) throws DAOException;
// many more methods
}
