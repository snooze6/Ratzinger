package rc.diego.model.task;

/**
 * Created by entakitos on 21/02/16.
 */
public interface InterfaceTaskManager {
    void runTask(InterfaceTask task);
    void runAsyncTask(InterfaceTask task);
}
