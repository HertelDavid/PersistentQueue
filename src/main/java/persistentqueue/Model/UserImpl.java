package persistentqueue.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import persistentqueue.Service.ConversationIdentificationService;

import java.security.Principal;

public class UserImpl extends User implements PersistentQueueObject {

    private Principal userPrincipal;

    public UserImpl(){}

    public void setUserPrincipal(Principal userPrincipal){
        this.userPrincipal = userPrincipal;
    }

    public Principal getUserPrincipal(){
        return userPrincipal;
    }

    @Override
    public void dequeueOperation() {

        CottonReturnMessage cottonReturnMessage = new CottonReturnMessage(conversationIdentificationService.getConversationID(), getUsername(), userPrincipal.getName());
        simpMessagingTemplate.convertAndSendToUser(getUserPrincipal().getName(), "/private",  cottonReturnMessage);
    }

    public MessageHeaders getHeaders(){
        SimpMessageHeaderAccessor head = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        head.setSessionId("0");
        head.setLeaveMutable(true);
        return head.getMessageHeaders();
    }

    @Override
    public void enqueueOperation() {
        System.out.println("User " + getUsername() + " has been queued");
    }
}
