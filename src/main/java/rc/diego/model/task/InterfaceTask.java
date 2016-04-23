package rc.diego.model.task;

import rc.diego.model.persistence.MySQL.DAOCdsMySQL;

import java.util.List;

/**
 * Created by entakitos on 19/02/16.
 */

/*
 * Each class must implement all posible input and output as properties of the class tha extends InterfaceTask
 */
public interface InterfaceTask {

    void run();

}
