package ba.bitcamp.homework25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpServer {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(8880);
			
			while (true) {
				Socket client = server.accept();

				BufferedWriter clientWriter = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));
				// BufferedReader clientReader = new BufferedReader(
				// new InputStreamReader(client.getInputStream()));
			
				String htmlDoc = "";

				BufferedReader reader = new BufferedReader(new FileReader(new File("src/ba/bitcamp/homework25/sites.html"
							)));		
				
				while (reader.ready()) {
					htmlDoc += reader.readLine();
				}
				
				BufferedReader fileReader = new BufferedReader(new FileReader(new File("src/ba/bitcamp/homework25/sites.txt")));
				
				while(fileReader.ready()) {
					
					String line = fileReader.readLine();
					StringTokenizer t = new StringTokenizer(line, " ");
					
					String link = t.nextToken();
					String name = t.nextToken();
					
					htmlDoc += "<a href=" + '"' + link + '"' + '>' + name + "</a> <br>" + "\n"; 
				}
				
				htmlDoc +=  "</body> </html>";

				clientWriter.write(htmlDoc);
				clientWriter.close();
				client.close();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
