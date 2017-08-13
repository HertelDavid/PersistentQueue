package persistentqueue.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import persistentqueue.Model.UserImpl;
import persistentqueue.Service.ConversationIdentificationService;
import persistentqueue.Service.PersistentQueueService;
import persistentqueue.Service.PersistentQueueThreadService;

import java.security.Principal;

@Controller
public class QueueController extends AbstractQueueController {

    @Autowired
    ConversationIdentificationService conversationIdentificationService;

    @Autowired
    public QueueController(PersistentQueueService queueService, PersistentQueueThreadService queueThreadService) {
        super(queueService, queueThreadService);
    }

    @MessageMapping("/add/persistent-queue")
    public void addUserToQueue(Principal principal, SimpMessageHeaderAccessor headerAccessor, UserImpl user){

        //Adds the designated user to the queue with the principal.
        //This is for later use when the queue needs to send a message back to the user.
        user.setUserPrincipal(principal);
        user.setMessagingTemplate(simpMessagingTemplate);
        user.setConversationIdentificationService(conversationIdentificationService);

        persistentQueue.enqueue(user);

        notifyPersistentThread();
    }
}
