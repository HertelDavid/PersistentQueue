package persistentqueue.Model;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;

import java.security.Principal;

public class UserImpl extends User implements PersistentQueueObject {

    private Principal userPrincipal;

    public UserImpl(){}

    public UserImpl(String username, String userId){
        this.setUsername(username);
        this.setUserId(userId);
    }

    public void setUserPrincipal(Principal userPrincipal){
        this.userPrincipal = userPrincipal;
    }

    public Principal getUserPrincipal(){
        return userPrincipal;
    }

    @Override
    public void dequeueOperation() {
        simpMessagingTemplate.convertAndSendToUser(getUserPrincipal().getName(), "/private", "Hello, " + this.getUsername());
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
