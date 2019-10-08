package skill.share.project.skillshare.dl;
import java.util.*;
public interface ThreadDAOInterface
{
public void add(ThreadDTOInterface thread) throws DAOException;
public void update(ThreadDTOInterface thread) throws DAOException;
public void delete(int code) throws DAOException;
public ArrayList<ThreadDTOInterface> getThreads() throws DAOException;
//public ThreadDTOInterface getThreadById() throws DAOException;
//public long getCount() throws DAOException;
public ThreadDTOInterface getByCode(int code) throws DAOException;
// many more methods
}
