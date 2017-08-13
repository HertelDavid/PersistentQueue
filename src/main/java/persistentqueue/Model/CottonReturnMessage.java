package persistentqueue.Model;

public class CottonReturnMessage {

    private ConversationIdentification conversationIdentification;
    private String username;
    private String userID;

    public CottonReturnMessage(ConversationIdentification conversationIdentification, String username, String userID){
        setConversationIdentification(conversationIdentification);
        setUsername(username);
        setUserID(userID);
    }

    public void setConversationIdentification(ConversationIdentification conversationIdentification){
        this.conversationIdentification = conversationIdentification;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public ConversationIdentification getConversationIdentification(){
        return conversationIdentification;
    }

    public String getUsername(){
        return username;
    }

    public String getUserID(){
        return userID;
    }
}
