package persistentqueue.Component;


import org.springframework.beans.factory.annotation.Autowired;
import persistentqueue.Service.ConversationIdentificationService;

public class CottonPersistentQueueThread extends PersistentQueueThread{

    private int numberOfUsersToRemove = 2;

    @Autowired
    ConversationIdentificationService conversationIdentificationService;

    @Override
    public void operation() {

        if(queueService.getQueue().queueThreadCondition()){

            //Build the Conversation identification so that when the users
            //are dequeued the server can send a message with to conversation ID to them.
            conversationIdentificationService.buildNewConversationID();
            queueService.getQueue().dequeue(numberOfUsersToRemove);
        }
    }
}
