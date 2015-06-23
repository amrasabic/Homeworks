package ba.bitcamp.homework.task05and10;

import ba.bitcamp.homework.part01.task03.Server;
import ba.bitcamp.homework.part01.task04.Clients;

public class Main {

	public static void main(String[] args) {

		Server s = new Server("Server", new char[12], 2);
		
		Clients c1 = new Clients("c1", new char[12]);
		Clients c2 = new Clients("c2", new char[12]);
		
		System.out.println(c1);
		
		
	}

}
