package persistentqueue.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.AbstractMessageSendingTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import persistentqueue.Service.ConversationIdentificationService;

public abstract class User{

    private String username;
    private String userId;
    private String conversationID;
    SimpMessagingTemplate simpMessagingTemplate;
    ConversationIdentificationService conversationIdentificationService;

    public void setUsername(String username){
        this.username = username;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUsername(){
        return username;
    }

    public String getUserId(){
        return userId;
    }

    public void setMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void print(){

        System.out.println("username: " + username + ", userID: " + userId);
    }

    public void setConversationIdentificationService(ConversationIdentificationService conversationIdentificationService){
        this.conversationIdentificationService = conversationIdentificationService;
    }
}
