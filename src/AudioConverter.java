

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voicerss.tts.AudioCodec;
import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.Languages;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;

/**
 * Servlet implementation class AudioConverter
 */
public class AudioConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AudioConverter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String completeLine= (String)request.getAttribute("completeLine");
		String location= (String)request.getAttribute("location");
		
		  VoiceProvider tts = new VoiceProvider("9464f6c534144da391fd59bbb7f1ca73");
			
	        VoiceParameters params = new VoiceParameters(completeLine, Languages.English_UnitedStates);
	        params.setCodec(AudioCodec.WAV);
	        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
	        params.setBase64(false);
	        params.setSSML(false);
	        params.setRate(0);
			
	        byte[] voice = null;
			try {
				voice = tts.speech(params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//response.setContentType("APPLICATION/OCTET-STREAM");   
			//response.setHeader("Content-Disposition","attachment; filename=\"" + voice + "\"");
			File mp3 = new File("C:/Users/garima/Downloads/apache-tomcat-7.0.37/webapps/voice.mp3");
			
			String filename = "C:/Users/garima/Downloads/apache-tomcat-7.0.37/webapps/voice.mp3";
			/*response.addHeader("Content-Disposition","attachment; filename=" + "voice.mp3" );   
			*/
			FileOutputStream fos = new FileOutputStream(filename);
	        fos.write(voice, 0, voice.length);
	        fos.flush();
	        fos.close();
	        
	        request.setAttribute("location", location);
	        RequestDispatcher rd = request.getRequestDispatcher("Download");
	        rd.forward(request, response);
	}

}
