package battleship;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IOThread {

	private InputStream in;
	private OutputStream out;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;

	public IOThread(Socket socket) {
		try {
			out = socket.getOutputStream();
			in = socket.getInputStream();
			objOut = new ObjectOutputStream(out);
			objIn = new ObjectInputStream(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object read() {
		Object obj = null;
		while (obj == null) {
			try {
				obj = objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public void write(Object obj) {
		try {
			objOut.writeObject(obj);
			objOut.flush();
		} catch (IOException e) {
		}
	}
}
