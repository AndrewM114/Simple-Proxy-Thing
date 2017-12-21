import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class ProxyServer {
	//TODO are these necessary????
	Socket otherSocket;
	int connSockPort;
	InetAddress connSockAddress;
	
	//TODO I might not even need these classes at all // you can prob delete TestClient class too
	HttpRequest httpReq = new HttpRequest();
	HttpResponse httpResp = new HttpResponse();
	
	
	//TODO Your proxy server should be set to run on port 5555 when it is submitted.
	public static void main(String argv[] ) throws Exception{
		ProxyServer main = new ProxyServer();
		//main.go();
		//main.testRequest();
		
		main.run();	//run() method is my most refined code. 
					//I may not actually even need to use the other methods or classes here. 
					//run() looks great. Remember to go back and read through your previous comments
					//For fun, perhaps when you are done, try doing this project again in python
					//to brush up on your python skills
					//P2P project is next though, don't forget about that.
		
		
		
	}
	/*
	public void go() throws UnknownHostException, IOException {
		
		ServerSocket welcomeSocket = new ServerSocket(5555);
				
		while (true) {
					
					Socket connectionSocket = welcomeSocket.accept();
					//connectionSocket.setKeepAlive(true);
					System.out.println("Open or closed First? "+connectionSocket.isClosed());
					connectionSocket.setKeepAlive(true);
					System.out.println("Open or closed Second? "+connectionSocket.isClosed());
					
					//System.out.println("connSock Port "+connectionSocket.getPort());
					//System.out.println("connSock Address "+connectionSocket.getInetAddress());
					//connSockAddress = connectionSocket.getInetAddress();
					//otherSocket = connectionSocket;
								
					DataInputStream in = 
							new DataInputStream(connectionSocket.getInputStream());
					
					System.out.println("Open or closed Third? "+connectionSocket.isClosed());
					
					
					Scanner input = new Scanner(in);
					
					String request_type;
					String temp = input.next();
					if (temp.equals("GET") 
							// || temp.equals("POST") 
							|| temp.equals("HEAD")
							|| temp.equals("PUT") 
							|| temp.equals("DELETE")) {
						request_type = temp;
					
						httpReq.parseRequest(input, request_type);
						
						//Socket outGoingSocket = new Socket(InetAddress.getByName(httpReq.host), 80);
						
						//DataOutputStream outToServer = 
						//		new DataOutputStream(
						//				outGoingSocket.getOutputStream());
						
						
						ArrayList<String> reqlist = httpReq.req;
						
						String outt = reqlist.get(0);
						System.out.println("print test "+ reqlist.get(0));
						
						for (int i = 1; i < httpReq.req.size(); i++) {
							outt += httpReq.req.get(i);
							System.out.println("print test "+ reqlist.get(i));
						}
						
						testRequest(connectionSocket);
						
						
						//outGoingSocket.close();
					}
					
				}
				
	}
	public void testRequest(Socket connectionSocket) throws UnknownHostException, IOException {
		
		InetAddress IPAddress = InetAddress.getByName("http://gaia.cs.umass.edu");
		
		HttpRequest httpReq = new HttpRequest();
		HttpResponse httpResp = new HttpResponse();
		
		Socket outGoingSocket = new Socket(IPAddress, 80);
		//System.out.println(outGoingSocket.getPort());
		//System.out.println(outGoingSocket.getInetAddress());
		
		String test_request = 
				  "GET /wireshark-labs/HTTP-wireshark-file1.html HTTP/1.1 \r\n"
				+ "Host: http://gaia.cs.umass.edu \r\n"
				+ "Connection: close \r\n"
				+ "User-agent: Mozilla/4.0 \r\n"
				+ "Accept-language: fr \r\n"
				+ "\r\n";
		
				//DataOutputStream outToServer = new DataOutputStream(
				//				connectionSocket.getOutputStream());
				
		PrintWriter pw = new PrintWriter(outGoingSocket.getOutputStream());
		pw.print(test_request);
		pw.println("");
		pw.flush();
				
				//outToServer.writeChars(test_request);
				
		DataInputStream in = 
				new DataInputStream(outGoingSocket.getInputStream());
		Scanner input = new Scanner(in);
				
				//System.out.print("thing "+ br.read());
		String t = "";
				
		while (input.hasNextLine())  {
			t += input.nextLine() + "\r\n";
					//System.out.println(t);
		}
		System.out.println("t" +t);
				
		System.out.println("Open or closed moment of truth? "+connectionSocket.isClosed());
				
		DataOutputStream outToServer = new DataOutputStream(
			connectionSocket.getOutputStream());
				
		PrintWriter pw2 = new PrintWriter(connectionSocket.getOutputStream());
		pw2.print(t);
		pw2.println("");
		pw.flush();
				
		//outToServer.writeBytes(t);
				
				
		outGoingSocket.close();
				
	}
	*/
	
	public void run() throws IOException {
		
		ServerSocket welcomeSocket = new ServerSocket(5555);
		
		//while true //(listening)
		while(true) {
			
			//get request from browser
			Socket connectionSocket = welcomeSocket.accept();
			DataInputStream in = 
					new DataInputStream(
							connectionSocket.getInputStream());
			
			
			
			String host = "";
			String tot = "";
			String full_req = "";
			
			
			
			//parse enough to get hostname, then reconstruct completely or just send on if possible
			
			//still not sure the best way to read this kind of stuff in
			//PrintWriter()? Scanner()? toString()?
			//String request = in.readLine();
			//String firstline = in.readLine();
			Scanner scan_test = new Scanner(in);
			Scanner req_scan = new Scanner(in);
			String firstline = req_scan.nextLine();
			//if(request.matches("^(GET).*")) {
			if (firstline.matches("^(GET).*")) {	//I don't even care that readLine() is deprecated. It does the job for me rn.
				String thing;
				ArrayList<String> reqlist = new ArrayList();
				
				System.out.println(firstline);
				
				//arraylist or full string????
				reqlist.add(firstline + "\r\n");
				full_req+=firstline + "\r\n";
				
				while (req_scan.hasNextLine()) {
					thing = req_scan.nextLine();
					//full_req+= thing + "\r\n";
					System.out.print(thing);
					if (thing.startsWith("Host:")) {
						System.out.print("	host thing: " + (host = thing.replaceAll("Host: ", "")));
					}
					//if (thing.startsWith("Accept:")) {
					//	thing = "Accept: text/html";
					//}
					
					reqlist.add(thing);
					full_req+= thing + "\r\n";
					if (thing.startsWith("Accept-Language:")) {
						break;
					}
				}
				//reqlist.add("");
				full_req += "\r\n\r\n";
				System.out.println("");
				System.out.print("fullreq: \r\n"+full_req);
				
				//TODO find out what a properly formed request to that same page looks like
				
				//System.out.println("print this thang! "+InetAddress.getByName(host));
				
				InetAddress address = InetAddress.getByName(host);
				String ip_address = address.getHostAddress();
				System.out.println(ip_address);
				
				Socket outGoingSocket = new Socket(ip_address, 80);//gaia.cs.umass.edu
				
				PrintWriter outToServer = new PrintWriter(outGoingSocket.getOutputStream());
				outToServer.print(full_req);
				outToServer.println("");
				outToServer.flush();
		
				//receive response on the same socket that you sent the request on		
					//this is all working, but it might need to modified to handle non-text data
				System.out.println("before inputStream");
				DataInputStream response = new DataInputStream(outGoingSocket.getInputStream());
				
				
				PrintWriter back2browser = new PrintWriter(connectionSocket.getOutputStream());
				DataOutputStream outToBrows = new DataOutputStream(connectionSocket.getOutputStream());
				
				int count;
				byte[] buffer = new byte[8192]; //8192 or 4096, or more
				while ((count = response.read(buffer)) > 0)
				{
				  outToBrows.write(buffer, 0, count);
				}
				
				
			}
			
			//this else statement will need fixed to actually handle something eventually.... OR ELSE!
			else {
				System.out.println("something");
				continue;
			}
			
		}	
	}
}
