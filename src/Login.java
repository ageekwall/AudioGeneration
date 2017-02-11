import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {

<<<<<<< HEAD
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("D:/Softwares/apache-tomcat-7.0.70-windows-x64/apache-tomcat-7.0.70/webapps/Todos.txt"));
		String line= null, completeLine = null;
		line = br.readLine();
		while(line !=null) {
			completeLine += line;
			line = br.readLine();
			//System.out.println(line);
			
		}
		
		br.close();
		System.out.println(completeLine);

=======
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Soumya is mad");
>>>>>>> branch 'master' of https://github.com/rohanksaxena/AudioGeneration.git
	}

}
