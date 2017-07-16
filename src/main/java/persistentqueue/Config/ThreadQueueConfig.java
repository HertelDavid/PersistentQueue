package persistentqueue.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import persistentqueue.Component.CottonPersistentQueue;
import persistentqueue.Component.CottonPersistentQueueThread;
import persistentqueue.Component.PersistentQueue;
import persistentqueue.Component.PersistentQueueThread;

@Configuration
public class ThreadQueueConfig extends AbstractThreadQueueConfig {

    @Bean
    @Override
    public PersistentQueue createQueue() {
        return new CottonPersistentQueue();
    }

    @Bean
    @Override
    public PersistentQueueThread createQueueThread() {
        return new CottonPersistentQueueThread();
    }
}
