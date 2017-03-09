import java.io.*;
import java.net.*;
import java.util.*;

public class EchoSerwer {
	private static ServerSocket server;
	private static final int PORT = 2345;

	public static void main(String args[]) {
		String[] cytaty = { "You talkin' to me?", "May the Force be with you.", "You�re gonna need a bigger boat.",
				"I�ll be back." };
		String linia;
		try {
			server = new ServerSocket(PORT);
			System.out.println("Serwer uruchomiony...");

			while (true) {
				Socket socket = server.accept();
				Scanner in = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Prosty serwer ECHO, komenda /end ko�czy dzia�anie.");
				int los = ((int) (Math.random() * 4));
				out.println("Cytat dnia: " + cytaty[los]);
				boolean koniec = false;
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {

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