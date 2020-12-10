import java.util.Scanner;

public class Network {
    public static void main(String[] args) throws InterruptedException {




        Scanner input = new Scanner(System.in);

        System.out.println("What's the Number of WI-FI connections?");
        int noConnections = input.nextInt();
        Router router = new Router(noConnections);

        System.out.println("What's the Number of devices Clients want to connect?");
        int noClients = input.nextInt();
        Device[] devices = new Device[noClients];

        System.out.println("What are the Clients' Names?");
        input=new Scanner(System.in);
        for (int i = 0; i < noClients; i++) {
            String line = input.nextLine();
            String[] data = line.split(" ");
            devices[i] = new Device(data[0],data[1], router);
        }

        for (int i = 0; i < noClients; i++) {
            Thread.sleep(500);
            devices[i].start();}
    }

}


