import java.io.*;
import java.net.*;
import java.util.*;

public class ServerLosowanie {
	private static ServerSocket server;
	private static final int PORT = 2345;

	public static void main(String args[]) {
		String linia;
		try {
			int los = ((int) (Math.random() * 101));
			server = new ServerSocket(PORT);
			System.out.println("Serwer uruchomiony...");
			while (true) {
				Socket socket = server.accept();
				Scanner in = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Zgadnij liczbe od 0 do 100, /pass kończy gre");
				boolean koniec = false;

				while (!koniec) {
					linia = in.nextLine();
					int wybor = Integer.parseInt(linia);
					if (linia.trim().toLowerCase().equals("/pass")) {
						koniec = true;
					} else {
						if (wybor == los) {
							out.println("Wygrales");
						} else if (wybor < los) {
							out.println("Za malo");
						} else if (wybor > los)
							out.println("Za duzo");
					}
				}
				socket.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
