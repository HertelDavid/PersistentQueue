package persistentqueue.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.AbstractMessageSendingTemplate;

public abstract class PersistentQueueObjectImpl implements PersistentQueueObject {

    @Autowired
    AbstractMessageSendingTemplate messageSendingTemplate;

    @Override
    public void dequeueOperation() {

    }

    @Override
    public void enqueueOperation() {

    }
}
