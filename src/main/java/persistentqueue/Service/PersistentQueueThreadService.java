package persistentqueue.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistentqueue.Component.PersistentQueueThread;

@Service
public class PersistentQueueThreadService {

    @Autowired
    PersistentQueueThread runnable;

    public PersistentQueueThread getPersistentQueueRunnable(){
        return runnable;
    }
    public Thread getPersistentQueueThread(){
        return new Thread(runnable);
    }
}
