import java.net.*;
import java.io.*;

public class SkanerPortow {
	public static void main(String[] args) {
		Socket socket;
		String host = "uek.krakow.pl";
		for (int i = 0; i < 10; i++) {
			try {
				socket = new Socket(host, i);
				System.out.println("Znalazłem serwer na porcie " + i + " komputera: " + host);
				socket.close();
			} catch (UnknownHostException e) {
				System.err.println(e);
				break;
			} catch (IOException e) {
			}
		}
	}
}