package ba.bitcamp.homework26.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * TASK #1 – CHECK IF FILE EXISTS Napraviti jedan server koji za klijenta
 * provjerava da li dati file na serverovom racunaru postoji. Nije potrebno
 * uraditi GUI za ovaj zadatak.
 * 
 * @author Amra
 *
 */
public class Client {

	public static void main(String[] args) {

		try {
			Socket server = new Socket("localhost", 1899);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					server.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					server.getInputStream()));

			Scanner in = new Scanner(System.in);
			System.out.println("Insert: ");
			writer.write(in.nextLine());
			writer.newLine();

			writer.flush();

			System.out.println(reader.readLine());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}