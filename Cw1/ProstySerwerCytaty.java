import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ProstySerwerCytaty {
	public static void main(String[] args) {
		String[] cytaty = { "You talkin' to me?", "May the Force be with you.", "You're gonna need a bigger boat.",
				"I'll be back." };
		try {
			ServerSocket server = new ServerSocket(2345);
			while (true) {
				System.out.println("Oczekuje na polczenie...");
				Socket socket = server.accept();
				InetAddress addr = socket.getInetAddress();
				System.out.println("Polaczenie z adresu: " + addr.getHostName() + " [" + addr.getHostAddress() + "]");
				int los = ((int) (Math.random() * 4));
				PrintWriter out = null;
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Cytat dnia: " + cytaty[los]);
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
