Decompiler.com
GetReplies.java
GetReplies.java
    package skill.share.project.skillshare;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skill.share.project.skillshare.dl.DAOException;
import skill.share.project.skillshare.dl.ThreadCommentDetailsDAO;
import skill.share.project.skillshare.dl.ThreadDetailsRequestDTO;

public class GetReplies extends HttpServlet {
   public void doPost(HttpServletRequest var1, HttpServletResponse var2) {
      try {
         BufferedReader var3 = var1.getReader();
         String var5 = "";

         while(true) {
            String var4 = var3.readLine();
            if (var4 == null) {
               var2.setContentType("application/json");
               PrintWriter var6 = var2.getWriter();
               Gson var7 = new Gson();
               ThreadDetailsApplicationResponse var8 = new ThreadDetailsApplicationResponse();

               try {
                  var2.setContentType("application/json");
                  ThreadDetailsRequestDTO var9 = (ThreadDetailsRequestDTO)var7.fromJson(var5, ThreadDetailsRequestDTO.class);
                  int var10 = var9.getThreadId();
                  ArrayList var11 = (new ThreadCommentDetailsDAO()).getThreadCommentDetails(var10);
                  var8.comments = var11;
                  var5 = var7.toJson(var8);
                  var6.print(var5);
               } catch (DAOException var12) {
                  System.out.println("daoexception");
               }
               break;
            }

            var5 = var4;
         }
      } catch (Exception var13) {
         System.out.println(var13);
      }

   }
}
    