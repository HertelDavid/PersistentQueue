package persistentqueue.Controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import persistentqueue.Service.PersistentQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import persistentqueue.Component.PersistentQueue;
import persistentqueue.Model.UserImpl;
import persistentqueue.Service.PersistentQueueThreadService;

import javax.annotation.PostConstruct;
import java.security.Principal;

public abstract class AbstractQueueController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    final PersistentQueueService queueService;
    final PersistentQueueThreadService queueThreadService;
    final PersistentQueue persistentQueue;
    final Thread starter;

    @Autowired
    AbstractQueueController(PersistentQueueService queueService, PersistentQueueThreadService queueThreadService){
        this.queueService = queueService;
        this.queueThreadService = queueThreadService;
        this.persistentQueue = queueService.getQueue();
        starter = new Thread(queueThreadService.getPersistentQueueRunnable());
        starter.start();
    }

    synchronized void notifyPersistentThread(){

        if(persistentQueue.queueThreadCondition()){
            synchronized(queueThreadService.getPersistentQueueRunnable().getMonitor()){
                queueThreadService.getPersistentQueueRunnable().getMonitor().notifyAll();
            }
        }
    }
}
