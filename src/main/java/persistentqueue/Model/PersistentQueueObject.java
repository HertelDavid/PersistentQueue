package persistentqueue.Model;

public interface PersistentQueueObject {
    public abstract void dequeueOperation();
    public abstract void enqueueOperation();
}
