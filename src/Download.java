

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  //File mp3 = new File("E:/voice.mp3");
		 // FileOutputStream mp3 = new FileOutputStream("D:/Softwares/apache-tomcat-7.0.70-windows-x64/apache-tomcat-7.0.70/webapps/voice.mp3");
		String filename =   "D:/Softwares/apache-tomcat-7.0.70-windows-x64/apache-tomcat-7.0.70/webapps/voice.mp3";
		ServletOutputStream stream = null;
		  BufferedInputStream buf = null;
		  try {
		    stream = response.getOutputStream();
		  //  File mp3 = new File("/myCollectionOfSongs" + "/" + fileName);
		    
		    //set response headers
		    response.setContentType("audio/mpeg"); 
		    String fileName="voice11.mp3";

		    response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

		    //response.setContentLength((int) mp3.length());

		    FileInputStream input = new FileInputStream(filename);
		    buf = new BufferedInputStream(input);
		    int readBytes = 0;
		    //read from the file; write to the ServletOutputStream
		    while ((readBytes = buf.read()) != -1)
		      stream.write(readBytes);
		  } catch (IOException ioe) {
		    throw new ServletException(ioe.getMessage());
		  } finally {
		    if (stream != null)
		      stream.close();
		    if (buf != null)
		      buf.close();
		  }

}
}
