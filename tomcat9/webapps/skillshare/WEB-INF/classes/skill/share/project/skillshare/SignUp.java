
package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
import java.io.*;
import java.nio.file.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SignUp extends HttpServlet
{
public void doPost(HttpServletRequest rq,HttpServletResponse rs)
{
	try
	{
		String username=rq.getParameter("userName");
		String email=rq.getParameter("email");
		String password=rq.getParameter("passWord");
		Connection con=DAOConnection.getConnection();
		/*
		PreparedStatement ps=con.prepareStatement("select * from user_account where user_name=?");
		ps.setString(1,username);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		rs.sendRedirect("homePage.jsp?userNameExists='ddvd'");
		}
		ps.close();
		rs.close();
		
		ps=con.prepareStatement("select * from user_account where email=?");
		ps.setString(1,email);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		rs.sendRedirect("homePage.jsp?emailExist='ddvd'");
		}
		ps.close();
		rs.close();
		
		ps=con.prepareStatement("select * from user_account where password=?");
		ps.setString(1,email);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		rs.sendRedirect("homePage.jsp?passwordExist='ddvd'");
		}
		ps.close();
		rs.close();
		*/


			//exist user ka check lagana he ....select user and if exist then show a msgbox for some timeout
			String sql="insert into user_account (user_name,email,password) values (?, ?, ?)";
			
			PreparedStatement st=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1,username);
			st.setString(2,email);
			st.setString(3,password);
			st.executeUpdate();
			ResultSet resultSet=st.getGeneratedKeys();
			resultSet.next();
			int code=resultSet.getInt(1);
			st.close();
			st=con.prepareStatement("insert into user_profile (user_id,profile_picture) values(?,?)");
			st.setInt(1,code);
			st.setString(2,"images/user_profile.png");
			st.executeUpdate();
			//HttpSession session=rq.getSession();
		
			
			st.close();
			con.close();
			rs.sendRedirect("homePage.jsp");
		
	}catch(Exception exception)
	{
	System.out.println(exception);
	}
}
}