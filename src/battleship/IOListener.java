package battleship;

import java.net.Socket;

public interface IOListener {

	void onLineRead(String line);

	void onCloseSocket(Socket socket);
	
	void write(String text);

}
