package ba.bitcamp.homeworkJSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;
/**
 * 
 * @author Amra
 *
 */
public class Server {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		Date d = new Date();
		
		ObjectMapper mapper = new ObjectMapper();
		ServerSocket server;
		
		Random rand = new Random();
		ArrayList<String> random = new ArrayList<>();
		
		try {
			
			server = new ServerSocket(8000);
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new FileReader(new File("src/random.txt")));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			InputStream in = client.getInputStream();

			File file = new File("sent.json");
			FileOutputStream fileWrite = new FileOutputStream(file, true);

			byte[] data = new byte[1024];
			int bytesRead;

			while ((bytesRead = in.read(data, 0, data.length)) > 0) {
				fileWrite.write(data, 0, bytesRead);
				fileWrite.flush();
			}
			in.close();
			
			ArrayList<Msg> list = mapper.readValue(new File("output.json"),
					ArrayList.class);
			System.out.println(list);
			
			String time = "" + d.getTime();
			
			
			list.add(new Msg("Amra", time, "No pain no gain"));
			mapper.writeValue(file, list);
			Socket client = new Socket("10.0.82.27", 8000);
			OutputStream os = client.getOutputStream();

			File file1 = new File("output.json");
			FileInputStream fileRead = new FileInputStream(file1);

			byte[] data1 = new byte[1024];
			int bytesRead1;

			while ((bytesRead1 = fileRead.read(data1, 0, data1.length)) > 0) {
				os.write(data, 0, bytesRead1);
				os.flush();
			}
			fileRead.close();
//			System.out.println(list);
			
//			mapper.writeValue(, list);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
