package ba.bitcamp.homework.task05and10;

import java.util.Random;

import ba.bitcamp.homework.part01.task01.Computer;
import ba.bitcamp.homework.part01.task03.Server;
import ba.bitcamp.homework.part01.task04.Clients;
import ba.bitcamp.homework.part04.task02.StarNetwork;

public class Main {

	public static void main(String[] args) {

		char[] macAddress = setMACAddress();
		System.out.println(macAddress);
		
		Server s = new Server("Server", setMACAddress(), 2);
		
		Computer c1 = new Computer("PC1", setMACAddress()) {
		};
		Computer c2 = new Computer("PC2", setMACAddress()) {
		};
		
		Clients client1 = new Clients("c1", setMACAddress());
		Clients client2 = new Clients("c2", setMACAddress());
		
		System.out.println(client1);
	//	client1.connect(c1);
		
		StarNetwork sn = new StarNetwork("SN", s);
		
	//	sn.addComputer(c1);
	//	sn.addComputer(c2);
	//	sn.removeComputer(c2); 
		
		System.out.println("Number of computers on server: "+ sn.getListOfComputer().length);
		System.out.println("Is server functioning: " + sn.isFunctioning());
		
	}
	
	// this wasn't included in task
	
	/**
	 * Set random MAC Address 
	 * <p>
	 * Generate MAC address within range of char - 0123456789abcdf
	 * @return - MAC Address
	 */
	public static char[] setMACAddress() {
		char[] MACAddress = new char[12];
		Random r = new Random();

		String generateMACAddress = "0123456789abcdef";
		for (int i = 0; i < 12; i++) {
			MACAddress[i] = generateMACAddress.charAt(r.nextInt(generateMACAddress.length()));
		}
		return MACAddress;
	}
	
}
