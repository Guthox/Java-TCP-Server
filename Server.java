import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    private ServerSocket server;
    private int port;
    private Socket client;

    public Server(int port){
        this.port = port;
    }

    public boolean startServer(){
        try{
            server = new ServerSocket(getPort());
            return true;
        }
        catch(IOException e){
            return false;
        }
    }

    public int getPort(){
        return this.port;
    }

    public String getData(){
        client = acceptClient();
        if (client == null){
            return "";
        }
        InputStream input;
        try{
            input = client.getInputStream();    
        }
        catch(IOException e){
            return "";
        }

        byte[] data = new byte[255];
        try{
            input.read(data);
            return new String(data);
        }
        catch(IOException e){
            return "";
        }
        
    }

    private Socket acceptClient(){
        try{
            return this.server.accept();
        }
        catch(IOException e){
            return null;
        }
    }

}