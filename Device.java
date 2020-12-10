public class Device extends Thread {
    String type ;
    int connectionNumber;
    public static Router router;
    Device(String name , String type ,Router r){
        this.setName(name);
        router=r;
        this.type=type;
        connectionNumber=0;
    }

    public int getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public void run(){
        router.semaphore.P(this);

        try {
            this.setConnectionNumber(router.occupy(this));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Connection "+ this.getConnectionNumber()+" : "+ this.getName()+ router.preformOnlineActivity());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Connection "+ this.getConnectionNumber()+" : "+ this.getName()+ router.logOut(this));

        router.semaphore.V(this);

    }

}
