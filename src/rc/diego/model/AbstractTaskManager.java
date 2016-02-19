package rc.diego.model;

/**
 * Created by entakitos on 19/02/16.
 */
public class AbstractTaskManager {

    public void runTask(AbstractTask task){
        task.run();
    }

    public void runAsyncTask(AbstractTask task){

        new Thread(() -> task.run()).start();

    }

}
