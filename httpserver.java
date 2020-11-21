package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;



public class httpserver {
		private static int port=80;
		private static String message;
		private static ServerSocket server;
	public static void main(String[] args) throws IOException {
		
		if(args.length==1) {
			message=args[0];
		}else if (args.length == 2 ) {
			try{Integer.class.isInstance (Integer.parseInt(args[0]));
			}catch(Exception e){
				System.out.println("You might entered a wrong port number");
				System.exit(64);
			}
			port=Integer.parseInt(args[0]);
			message=args[1];
		} else 	 {
			System.out.println("Usage: httpserver port[80] message\nThis is a simple program that creates a simple httpserver");
			System.exit(64); 
		} 
		
		server=new ServerSocket(port);
		System.out.println("Connecting to port "+port+"!");
		
		while(true) {
			try(Socket socket=server.accept()){
				String myResponse="Yeah it's working , can you believe it?\nIs this what you wanted to see:\n"+message;
				String response="HTTP1/1 200 OK\r\n\r\n"+myResponse;
				socket.getOutputStream().write(response.getBytes("UTF-8"));
			}
		}
		
	}
//	TRYING TO IMPLEMENT SOMETHING: USER INPUTS SOMETHING ==> CHANGE THE MESSAGE IN THE WEBPAGE!	
//	private static String   runPrompt() throws IOException {
//	    InputStreamReader input = new InputStreamReader(System.in);
//	    BufferedReader reader = new BufferedReader(input);
//
//	    for (;;) { 
//	      System.out.print("> ");
//	      String line = reader.readLine();
//	      if (line == null) break;
//	      return line;
//	  }return "";
//	}
}

