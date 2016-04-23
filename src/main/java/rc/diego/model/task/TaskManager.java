package rc.diego.model.task;

import rc.diego.model.persistence.MySQL.DAOCdsMySQL;

/**
 * Created by entakitos on 19/02/16.
 */
public class TaskManager implements InterfaceTaskManager{

    @Override
    public void runTask(InterfaceTask task) {
        task.run();
    }

    @Override
    public void runAsyncTask(InterfaceTask task){
        new Thread(() -> {
            task.run();
        }).start();

    }

}
