import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
	
	public void send() throws Exception {
	
		Socket testSocket = new Socket("localhost", 1689);
		OutputStream outToServer = testSocket.getOutputStream();

		DataOutputStream out = new DataOutputStream(outToServer);
	
	
		String test_response = 
			  "HTTP/1.1 200 OK\r\n"
			+ "Connection: close\r\n"
			+ "Date: Sat, 07 Jul 2007 12:00:15 GMT\r\n"
			+ "Server: Apache/1.3.0 (Unix)\r\n"
			+ "Last-Modified: Sun, 6 May 2007 09:23:24 GMT\r\n"
			+ "Content-Length: 6821\r\n"
			+ "Content-Type: text/html\r\n"
			+ "\r\n"
			+ "data data data data data data\r\n";
	
		String test_request = 
			  "GET /somedir/page.html HTTP/1.1\r\n"
			+ "Host: www.someschool.edu\r\n"
			+ "Connection: close\r\n"
			+ "User-agent: Mozilla/4.0\r\n"
			+ "Accept-language: fr\r\n"
			+ "\r\n";
		
		
	
		out.writeBytes(test_response);
	}

}
