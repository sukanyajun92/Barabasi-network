import java.io.File;
import java.io.FileNotFoundException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Node {

	int nodeId;
	Socket clientSocket;
	ServerSocket serverSocket;
	DatagramSocket datagramclient;
	DatagramSocket datagramserver;
	int tcpPort[] = new int[10];
	int udpPort[] = new int[10];
	
	public Node(int id) {
		nodeId = id;
		clientSocket = null;
		serverSocket = null;
		datagramclient = null;
		datagramserver = null;
	}	
	
	//New incoming nodes know about m0 nodes IP address and UDP port numbers
	public Map readInitialNodesInfo() {
		String fileName = "";   //give file name
		int udp_port = 0;
		String ipAddress = "";
		Scanner inputFile = null;
		Map map = new TreeMap<String, Integer>();
		
		//Open the file 
		File myFile = new File(fileName); 
		try {
			inputFile = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannot open the file!!");
		}
		
		//Read lines from the file until the end
		while(inputFile.hasNext()) {
			String str = inputFile.nextLine();
			System.out.println(str);  //printing for testing
			StringTokenizer strTokenizer = new StringTokenizer(str, " ");
			while(strTokenizer.hasMoreTokens()) {
				ipAddress = strTokenizer.nextToken();
				System.out.println("Ip address is " + ipAddress);  //printing for testing
				String udp = strTokenizer.nextToken();
				udp_port = Integer.parseInt(udp);   //printing for testing
				System.out.println("Udp port is " + udp_port);
			}
			map.put(ipAddress, udp_port);  //Add the information to a map 			
		}
		
		inputFile.close();  //Close the file
		
		return map;
		
	}
	
	
		
}
