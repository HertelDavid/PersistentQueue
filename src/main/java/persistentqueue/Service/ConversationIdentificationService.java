package persistentqueue.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistentqueue.Model.ConversationIdentification;

import java.util.Date;

@Service
public class ConversationIdentificationService {

    private ConversationIdentification conversationID;

    public void buildNewConversationID(){
        Date date = new Date();
        conversationID = new ConversationIdentification(String.valueOf(date.getTime()));
    }

    public ConversationIdentification getConversationID(){
        return conversationID;
    }
}
