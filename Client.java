package structure;
import java.net.*;
import java.io.*;

public class Client {
public static void main (String []args) throws IOException {
	File file = new File("C:\\Users\\Leika Yamada\\Desktop\\360 Software Development\\roger.txt");
	  
        
				
					try { 
						//prepares socket to accept incoming data
                      ServerSocket ss = new ServerSocket(1999); 
                      Socket s = ss.accept(); 
                      //accepts the input
                      DataInputStream dis = new DataInputStream(s.getInputStream()); 
                      String k = dis.readUTF(); 
                      
                      System.out.println("File Transferred"); 
                      //copies data into the file
                      FileOutputStream fos = new FileOutputStream("C:\\Users\\Leika Yamada\\Desktop\\360 Software Development\\roger.txt"); 
                      byte[] b = k.getBytes(); 
                      fos.write(b); 
                      
                     } catch (IOException ie) { 
                       ie.printStackTrace(); 
                     }
					
				
          }
}
