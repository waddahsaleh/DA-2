import java.io.*;
import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FileServer {
   public static void main(String argv[]) {
     // if (System.getSecurityManager() == null) {
      //   System.setSecurityManager(null);
    // }
      try {
         FileInterface fi = (FileInterface) UnicastRemoteObject.exportObject(new FileImpl("FileServer"), 0);
         Registry reg = LocateRegistry.getRegistry();

         reg.rebind("FileServer",fi);
         System.out.println("Server Ready - service is running...");


      } catch(Exception e) {
         System.out.println("FileServer: "+e.getMessage());
         e.printStackTrace();
      }
   }
}