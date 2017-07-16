package persistentqueue.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistentqueue.Component.CottonPersistentQueue;
import persistentqueue.Component.PersistentQueue;

@Service
public class PersistentQueueService {

    @Autowired
    PersistentQueue queue;

    public PersistentQueue getQueue(){
        return queue;
    }
}
