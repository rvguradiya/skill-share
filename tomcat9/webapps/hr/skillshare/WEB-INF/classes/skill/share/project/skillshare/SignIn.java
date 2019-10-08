package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SignIn extends HttpServlet
{
public void doPost(HttpServletRequest rq,HttpServletResponse rs)
{ 
try
{
String username=rq.getParameter("userName");
String password=rq.getParameter("passWord");
			//DATABASE varify Class.forName();
			String sql="select * from user_account where user_name=? and password=?";
			Connection con=DAOConnection.getConnection();
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rst=st.executeQuery();
			if(rst.next())
			{	 int userId=rst.getInt(1);
				 String userName=rst.getString(2);
				 String email=rst.getString(3);
				password=rst.getString(4);
				HttpSession session=rq.getSession();
				session.setAttribute("email",email);
				session.setAttribute("userName",userName);
				session.setAttribute("userId",userId);
				System.out.println("uid in signin servlet  "+userId);
				st.close();
				con.close();
				rs.sendRedirect("/skillshare/homePage.jsp");
			}
			else
			{
				HttpSession session=rq.getSession();
				session.setAttribute("logout","not login");
				st.close();
				con.close();
				rs.sendRedirect("homePage.jsp");
			}
System.out.println("email : "+username+" Password : "+password);

}catch(Exception exception)
{
System.out.println(exception);
}
}
}