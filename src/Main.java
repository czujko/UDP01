import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        InetAddress destino = InetAddress.getLocalHost();
        int port = 9003;
        byte[] mensaje = new byte[1024];

        String mensaje_enviar = "Hola, soy el servidor";
        mensaje = mensaje_enviar.getBytes();

        DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(9999);

        System.out.println("Enviando mensaje: " + mensaje_enviar);
        System.out.println("Nombre: " + paquete.getAddress().getHostName());
        System.out.println("IP Destino: " + destino.getHostAddress() + ":" + port);
        System.out.println("Tamaño: " + paquete.getLength());
        System.out.println("Puerto salida: " + paquete.getPort());
        System.out.println("Puerto destino: " + socket.getLocalPort());
        System.out.println("Paquete: " + paquete);


        socket.send(paquete);
        socket.close();
    }
}
