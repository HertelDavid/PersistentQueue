package persistentqueue.Component;


public class CottonPersistentQueueThread extends PersistentQueueThread{

    private int numberOfUsersToRemove = 2;

    @Override
    public void operation() {

        if(queueService.getQueue().queueThreadCondition()){
            queueService.getQueue().dequeue(numberOfUsersToRemove);
        }
    }
}
