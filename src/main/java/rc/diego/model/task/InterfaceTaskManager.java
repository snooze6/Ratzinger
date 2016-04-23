package rc.diego.model.task;

import rc.diego.model.persistence.MySQL.DAOCdsMySQL;

/**
 * Created by entakitos on 21/02/16.
 */
public interface InterfaceTaskManager {
    void runTask(InterfaceTask task) throws DAOCdsMySQL.CdAlreadyExistsException;
    void runAsyncTask(InterfaceTask task);
}
