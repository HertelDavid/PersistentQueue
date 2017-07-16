package persistentqueue.Component;

import org.springframework.beans.factory.annotation.Autowired;
import persistentqueue.Service.PersistentQueueService;


/*
 * Documentation: Implement this class and operation() to decide what to do when the
 * queue condition is true. AbstractQueueController has a method that notifies the thread that
 * will tell this class to run and call the operation method.
 */

public abstract class PersistentQueueThread implements Runnable {

    @Autowired
    PersistentQueueService queueService;

    final Object monitor = new Object();

    public synchronized void threadWait() throws InterruptedException {
        monitor.wait();
    }

    public synchronized void threadNotify() throws InterruptedException{
        monitor.notify();
    }

    public Object getMonitor(){
        return monitor;
    }

    @Override
    public synchronized void run() {

        while(true){

            synchronized(monitor){

                operation();

                try{
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public abstract void operation();
}
