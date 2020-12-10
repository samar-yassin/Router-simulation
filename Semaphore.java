public class Semaphore {
    protected int value=0;
    protected Semaphore() { value=0;}
    protected Semaphore(int intial) { value=intial;}
    public synchronized void P(Device d){
        value--;
        if(value<0) {
            try {
                System.out.println(d.getName() + " arrived and waiting");

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {System.out.println(d.getName() + " arrived"); }

        }

    public  synchronized void V(Device d){
        value++;
        if(value<=0) {
            notify();
        }
    }

}
