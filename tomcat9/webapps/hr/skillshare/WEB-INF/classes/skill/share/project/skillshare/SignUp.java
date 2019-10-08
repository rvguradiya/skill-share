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
			//exist user ka check lagana he ....select user and if exist then show a msgbox for some timeout
			String sql="insert into user_account (user_name,email,password) values (?, ?, ?)";
			Connection con=DAOConnection.getConnection();
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,username);
			st.setString(2,email);
			st.setString(3,password);
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