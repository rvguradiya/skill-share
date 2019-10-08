package com.thinking.machines.hr;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileUploadServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//get the file chosen by the user

		String fileName = "";
		
		for (Part filePart : request.getParts()) {
System.out.println(filePart.getSubmittedFileName());
System.out.println(filePart.getSize());

			if(filePart.getSubmittedFileName().equals(""))
{
System.out.println("null");
return;
}
		// filePart = request.getPart("fileToUpload"); if single file is comes we use getPart() else use getParts()
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    	System.out.println(fileInputStream);
	    //for example, you can copy the uploaded file to the server
	    //note that you probably don't want to do this in real life!
	    //upload it to a file host like S3 or GCS instead
	    File fileToSave = new File( "C:/tomcat9/webapps/hr/images/abc"+"/arun/"+filePart.getSubmittedFileName());
		fileToSave.getParentFile().mkdirs();
		//to create a direcotry if not exist
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}






		//get the URL of the uploaded file
		//String fileUrl = "http://localhost:8080/hr/images/" + filePart.getSubmittedFileName();
		
		//You can get other form data too
		String name = request.getParameter("name");
		
		//create output HTML that uses the 
		response.getOutputStream().println("<p>Thanks " + name + "! Here's a link to your uploaded file:</p>");
		//response.getOutputStream().println("<p><a href=\"" + fileUrl + "\">" + fileUrl + "</a></p>");
		response.getOutputStream().println("<p>Upload another file <a href=\"http://localhost:8080/index.html\">here</a>.</p>");	
	}
}