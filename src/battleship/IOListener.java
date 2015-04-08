package battleship;

import java.net.Socket;

public interface IOListener {

	void onCloseSocket(Socket socket);
	
	void write(Object obj);

}
