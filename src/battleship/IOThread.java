package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class IOThread extends Thread implements IOListener {
	// read individ lines from stream and do something with it
	private Socket socket;
	private PrintWriter pw;
	private String line;

	public IOThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		InputStream in;
		OutputStream out;
		try {
			out = socket.getOutputStream();
			pw = new PrintWriter(out);
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				// tells listener that read a line
				this.onLineRead(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// tell listener when program ends
		this.onCloseSocket(socket);
	}

	@Override
	public void onLineRead(String line) {
		this.line = line;
	}

	public String read() {
		return line;
	}

	@Override
	public void onCloseSocket(Socket socket) {

	}

	@Override
	public void write(String text) {
		pw.write(text);
		pw.flush();

	}
}
