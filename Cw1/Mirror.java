import java.io.*;
import java.net.*;
import java.util.*;

public class Mirror {
	private static ServerSocket server;
	private static final int PORT = 2345;

	public static void main(String args[]) {
		String linia;
		try {
			server = new ServerSocket(PORT);
			System.out.println("Serwer uruchomiony...");
			while (true) {
				Socket socket = server.accept();
				Scanner in = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Prosty serwer ECHO, komenda /end ko�czy dzialanie.");
				boolean koniec = false;
				while (!koniec) {
					linia = in.nextLine();
					if (linia.trim().toLowerCase().equals("/end")) {
						koniec = true;
					} else {
						String reverse = new StringBuffer(linia).reverse().toString();
						out.println(reverse);
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