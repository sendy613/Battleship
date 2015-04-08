package battleship;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IOThread extends Thread implements IOListener {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;

	public IOThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {
			out = socket.getOutputStream();
			in = socket.getInputStream();
			objOut = new ObjectOutputStream(out);
			objIn = new ObjectInputStream(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.onCloseSocket(socket);
	}

	public Object read() {
		//need a flusher for a new object? - does the old object sit in the stream after it's read?
		try {
			return objIn.readObject();
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
		return new Object();
	}

	@Override
	public void onCloseSocket(Socket socket) {
		//do what??
	}

	@Override
	public void write(Object obj) {
		try {
			objOut.writeObject(obj);
		} catch (IOException e) {
		}
	}
}
