import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;


public class HttpRequest {
	
	
	
	/*
	 *  1. The proxy listens for requests from clients (Example server code in section 2.7 of the book)
		2. When there is a request, the proxy parses the HTTP request coming from the browser, reads the
		“Host:” field and then opens a socket connection to the remote server. The proxy server will then
		forward this HTTP request to the server. If the request does not contain the Host: field, just print
		an error message.
		3. The proxy server then reads in the server’s reply. Keep in mind the format of the HTTP Response
		message from the book. The response has a header, which contains the “Content-length” field and
		the “Content-type” field. These fields tell you how many bytes need to be read from the input
		stream and what type of data is coming in. Is it text (String) or image (binary)? Note that these
		two cases are not handled the same way!
		4. The server then sends the response back to the requesting client.
		5. This process repeats for all objects in the web page.
	 * 
	 * 
	 * 
	 * 
	 * 
		Caching the responses on the local hard drive is (for now) left as an optional exercise, since it demands a
		significant amount of additional work. The basic functionality of caching goes as follows.
		1. When the proxy gets a request, it checks if the requested object is cached, and if yes, gets the time
		the file was last modified and sends this in a conditional get request to the server. If the server
		responds with a 304 message, the cache sends the local copy of the data.
		2. If the object is not cached, the proxy retrieves the object from the server using a traditional HTTP
		get request, returns it to the client, and caches a copy for future requests. 
	
	
	 */
	//first line
	String request_type;
	String request_object;
	String version;
	//second line
	String host;
	//third line
	String connection;
	//4th line
	String user_agent;
	//5th line
	String accept_language;
	
	
	public ArrayList<String> req = new ArrayList();
	
	/*
	 * String test_request = 
			  "GET /somedir/page.html HTTP/1.1\r\n"
			+ "Host: www.someschool.edu\r\n"
			+ "Connection: close\r\n"
			+ "User-agent: Mozilla/4.0\r\n"
			+ "Accept-language: fr\r\n"
			+ "\r\n";
	 */
	//this will not be a String but rather a DataInputReader in the final product
	public void parseRequest(Scanner input, String req_type) {
		//perhaps instead of putting them into variables, put them as entries into an array list, so then
		//when I "pass on" the things I can just go down the arraylist in order and send them out.
		
		System.out.println("\nparseRequest() called");
		
		System.out.println(req_type);
		System.out.println("req_object: " + (request_object = input.next()));
		System.out.println("version: " + (version = input.next()));
		
		//System.out.println("req_type: " + (request_type = req_type));
		System.out.println();
		
		req.add(req_type +" "+ request_object +" "+ version + "\r\n");  // line 1
		input.nextLine();
		//req.add(input.nextLine());// + "\r\n"); //line 2
		req.add(input.nextLine() + "\r\n"); //line 3
		req.add(input.nextLine() + "\r\n"); //line 4
		req.add(input.nextLine() + "\r\n"); //line 5
		req.add(input.nextLine() + "\r\n\r\n"); //line 6
		
		for (int i = 0; i < req.size(); i++) {
			System.out.println("List print: " +req.get(i));
		}
		
		
		/*
		//request_type = req_type;
		System.out.println("version: " + (version = input.next()));
		input.nextLine();
		System.out.println("host: " + (host = input.findInLine("[^Host: ].*")));
		input.nextLine();
		System.out.println("connection: " + (connection = input.findInLine("[^Connection:].*")));
		input.nextLine();
		System.out.println("user_agent: " + (user_agent = input.findInLine("[^User\\-agent: ].*")));
		input.nextLine();
		System.out.println("accept_language: " + (accept_language = input.findInLine("[^Accept\\-language: ].*")));
		*/
		
		//input.close();	
	}
}
