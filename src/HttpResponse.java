import java.io.DataInputStream;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class HttpResponse {
	
	
	//first line
	String version;
	String status;
	//second line
	String connection_status;
	//third line
	String date;
	//fourth line
	String server;
	//fifth line
	String last_modified;
	//sixth line
	String content_length; //amount of bytes in the entity body (what I'm putting in the data variable rn)
	//seventh line
	String content_type; 
	//last line (ninth?) //also, should it be string???
	String data;		//prob won't be leaving this as a String var
	
	ArrayList<String> request = new ArrayList();
	
	/*
	 * String test_response = 
					  "HTTP/1.1 200 OK\r\n"
					+ "Connection: close\r\n"
					+ "Date: Sat, 07 Jul 2007 12:00:15 GMT\r\n"
					+ "Server: Apache/1.3.0 (Unix)\r\n"
					+ "Last-Modified: Sun, 6 May 2007 09:23:24 GMT\r\n"
					+ "Content-Length: 6821"
					+ "Content-Type: text/html\r\n"
					+ "\r\n"
					+ "data data data data data data";
	 */
	
	//this will not be a String but rather a DataInputReader in the final product
		public void parseResponse(Scanner input, String vers) {
			System.out.println("\nparseResponse() called");

			
			
			System.out.println(version = vers);
			
			System.out.println(status = input.next() + " "+ input.next());
			input.nextLine();
			System.out.println(connection_status = input.findInLine("[^Connection:].*"));
			input.nextLine();
			System.out.println(date = input.findInLine("[^Date: ].*"));
			/*input.nextLine();
			System.out.println(server = input.findInLine("[^Server: ].*"));
			input.nextLine();
			System.out.println(last_modified = input.findInLine("[^Last\\-Modified: ].*"));
			input.nextLine();
			System.out.println(content_length = input.findInLine("[^Content\\-Length: ].*"));
			input.nextLine();
			System.out.println(content_type = input.findInLine("[^Content\\-Type:].*"));
			//depending on content-type process the next field differently
			
			//go 2 lines down from prev line
			input.nextLine(); 
			input.nextLine();
			
			while (input.hasNextLine()) {
				System.out.println(data = input.nextLine());
			}*/
			input.close();
		}
}
