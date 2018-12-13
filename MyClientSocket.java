import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class MyClientSocket extends Thread {
    private Socket socket;
    private Scanner scanner;
    public MyClientSocket(String serverAd, int serverPort) throws Exception {
        this.socket = new Socket(InetAddress.getByName(serverAd), serverPort);
        this.scanner = new Scanner(System.in);
    }
    private void iniciar() throws IOException {
        String input;
        while (true) {
            input = scanner.nextLine();
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println(input);
            out.flush();
        }
    }
    
    public void run() {

        try {
            System.out.println("\r\nConnected to Server: " + socket.getInetAddress()+socket.getPort());
            iniciar();  
            }          


        catch (Exception e) {
                System.out.println("Entro a Exception cliente");
            }


    }
}
