package persistentqueue.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import persistentqueue.Component.PersistentQueue;
import persistentqueue.Component.PersistentQueueThread;

@Configuration
public abstract class AbstractThreadQueueConfig {

    public abstract PersistentQueue createQueue();
    public abstract PersistentQueueThread createQueueThread();
}
