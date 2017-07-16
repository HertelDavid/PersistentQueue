package persistentqueue.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CottonPersistentQueue extends PersistentQueue {

    @Override
    public boolean queueThreadCondition(){
        return (size() >= 2);
    }
}
