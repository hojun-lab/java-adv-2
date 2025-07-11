package chatting_v2.client;

public class ClientMain {
    public static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost", PORT);
        client.start();
    }
}
