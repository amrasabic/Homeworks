package ba.bitcamp.homework25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/**
 * Napraviti jedan normalni server koji prima od klijenta dva String-a, jedan za
 * link, a drugi za ime linka. Server mora provjeriti da li je dati link validan
 * i postojeci. Ukoliko zadovoljava oba uslova onda zapisati dati link i dato
 * ime u File (koji ce HTTP server kasnije citati).
 * 
 * @author amra.sabic
 *
 */
public class Server {

	public static void main(String[] args) {

		ServerSocket server;

		try {
			server = new ServerSocket(1989);
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					"src/links"), true));

			String link = "";
			String name = "";

			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					link = reader.readLine();
				} else {
					name = reader.readLine();
				}
			}

			try {
				URL web = new URL(link);

				writer.write(name + " " + web);
				writer.newLine();
				writer.flush();

			} catch (MalformedURLException e) {
				System.out
						.println("Invalid link. Example of valid link: https://www.google.com");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}