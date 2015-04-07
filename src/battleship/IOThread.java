package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class IOThread extends Thread implements IOListener{
	// read individ lines from stream and do something with it
	private Socket socket;
	//private ReaderListener listener;
	
	public IOThread(Socket socket) {
		this.socket = socket;
		//this.listener = listener;
	}

	public void run() {
		InputStream in;
		try {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		// TODO Auto-generated method stub
		
	}
}
