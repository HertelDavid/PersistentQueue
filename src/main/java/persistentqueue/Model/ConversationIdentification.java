package persistentqueue.Model;

import java.util.Date;

public class ConversationIdentification {

    private String conversationID;

    public ConversationIdentification(String conversationID){
        this.conversationID = conversationID;
    }

    public String getConversationID(){
        return conversationID;
    }

    public void setConversationID(String conversationID){
        this.conversationID = conversationID;
    }
}
