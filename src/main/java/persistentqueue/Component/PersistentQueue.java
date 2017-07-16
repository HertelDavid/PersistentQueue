package persistentqueue.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import persistentqueue.Model.PersistentQueueObject;

import java.util.ArrayList;

/*
* Description: Persistent Queue is a queue that takes objects of the PersistentQueueObject
* type and performs their dequeue operations. Any object can inherit from the PersistentQueueObject
* interface in order to gain access to the queue.
 */

public abstract class PersistentQueue{

    protected int size = 0;
    protected ArrayList<PersistentQueueObject> queue;

    PersistentQueue(){
        queue = new ArrayList<>();
    }

    private void incrementSize(){
        size++;
    }

    private void decrementSize(){
        size--;
    }

    public int size(){
        return size;
    }

    public void enqueue(PersistentQueueObject[] persistentQueueObjects){

        for(PersistentQueueObject p: persistentQueueObjects){
            enqueue(p);
        }
    }

    public PersistentQueueObject enqueue(PersistentQueueObject p){

        queue.add(p);
        incrementSize();
        p.enqueueOperation();

        return p;
    }

    public PersistentQueueObject dequeue(){

        PersistentQueueObject p = queue.remove(0);
        decrementSize();
        p.dequeueOperation();

        return p;
    }

    public PersistentQueueObject[] dequeue(int objectsToDequeue){

        if(objectsToDequeue <= this.size()){

            PersistentQueueObject[] persistentQueueObjects = new PersistentQueueObject[objectsToDequeue];

            for(int i = 0; i < persistentQueueObjects.length; i++){

                PersistentQueueObject currentObject = this.dequeue();

                persistentQueueObjects[i] = currentObject;
            }

            return persistentQueueObjects;

        }else{

            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public PersistentQueueObject peak(){
        return queue.get(0);
    }

    public abstract boolean queueThreadCondition();
}