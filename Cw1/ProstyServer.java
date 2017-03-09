import java.net.*;
import java.io.*;

public class ProstyServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2345);
			while (true) {
				System.out.println("Oczekuje na po��czenie...");
				Socket socket = server.accept();
				InetAddress addr = socket.getInetAddress();
				System.out.println("Po��czenie z adresu: " + addr.getHostName() + " [" + addr.getHostAddress() + "]");
				pause(10000);
				socket.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
}
