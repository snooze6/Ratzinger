package rc.diego.model.task;

/**
 * Created by entakitos on 19/02/16.
 */
public class TaskManager implements InterfaceTaskManager{

    @Override
    public void runTask(InterfaceTask task){
        task.run();
    }

    @Override
    public void runAsyncTask(InterfaceTask task){

        new Thread(() -> task.run()).start();

    }

}
