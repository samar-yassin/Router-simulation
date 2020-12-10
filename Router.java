import static java.lang.Thread.sleep;

public class Router {
    public Semaphore semaphore;
    public String[] connections;
    public int noConnections ;
    public int occupied;

    public Router(int num) {
        occupied=0;
        noConnections = num;
        semaphore = new Semaphore(noConnections);
        connections = new String[noConnections];
        for(int i=0 ; i<noConnections ; i++){
            connections[i]="null";
        }
    }

    public synchronized int occupy (Device d) throws InterruptedException {
        for(int i = 0 ; i< noConnections ;i++){
            if(connections[i].equals("null")){
                occupied++;
                d.setConnectionNumber(i+1);
                System.out.println("Connection "+d.getConnectionNumber()+" : "+ d.getName()+" occupied.");
                connections[i]=d.getName();
                sleep(500);
                break;
            }
        }

        return d.getConnectionNumber();
    }



    public String preformOnlineActivity() throws InterruptedException {
        sleep(500);
        return (" performs online activity.");
    }

    public String logOut(Device d){
        occupied--;
        connections[d.getConnectionNumber()-1]="null";
        return (" logged out.");
    }





}
