public class Main{
    public static void main(String[] args) {
        
        Server server = new Server(7777);
        server.startServer();

        String data;
        while (true){
            data = server.getData();
            if (data != ""){
                System.out.print(data);
            }
        }

    }
}