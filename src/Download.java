import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  //File mp3 = new File("E:/voice.mp3");
		 // FileOutputStream mp3 = new FileOutputStream("D:/Softwares/apache-tomcat-7.0.70-windows-x64/apache-tomcat-7.0.70/webapps/voice.mp3");
		String location= (String)request.getAttribute("location");
		String path = "C:/Users/garima/Downloads/apache-tomcat-7.0.37/webapps/";
		String filename = "voice.mp3";
		String outFile = location + ".mp3";
		File file = new File(path + filename);
		response.setContentType("audio/mpeg");
		response.addHeader("Content-Disposition", "attachment; filename=" +filename);
		response.setContentLength((int) file.length());
		//ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outFile));
		int ch =0;
		while((ch=bufferedInputStream.read()) != -1){
			bufferedOutputStream.write(ch);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
		/*int byteRead = bufferedInputStream.read();
		System.out.println(byteRead);
		while(byteRead != -1){
			System.out.println(byteRead);
			servletOutputStream.write(byteRead);
			byteRead = bufferedInputStream.read();
		}
		if(servletOutputStream != null) servletOutputStream.close();
		if(bufferedInputStream != null) bufferedInputStream.close();*/
		
		
}
}
