import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class signin extends HttpServlet
{
public void doPost(HttpServletRequest rq,HttpServletResponse rs)
{ 
try
{
String username=rq.getParameter("userName");
String password=rq.getParameter("passWord");
			//DATABASE varify Class.forName();
			String sql="select *from user_account where user_name=? and password=?";
			Connection con=DAOConnection.getConnection();
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rst=st.executeQuery();
			if(rst.next())
			{
				username=rst.getString(2);
				String email=rst.getString(3);
				password=rst.getString(4);
				HttpSession session=rq.getSession();
				session.setAttribute("email",email);
				session.setAttribute("username",username);
				st.close();
				con.close();
				rs.sendRedirect("homePage.jsp");
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