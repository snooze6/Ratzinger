package rc.diego.model.persistence;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by entakitos on 17/02/16.
 */
public abstract class AbstractRepositoryManager extends AbstractALLDAOs implements InterfaceFactoryDAO{

    //ABSTRACT METHODS
    abstract void initialRepositories();
    abstract void configRepositoriesPreferences();

    //PROPERTIES
    private List<AbstractRepository> repositories = new LinkedList<>();


    //IMPLEMENTED METHODS
    protected void addRepository(AbstractRepository repository){
        repositories.add(repository);
    }

    public AbstractRepositoryManager(){
        initialRepositories();
        configRepositoriesPreferences();
    }

    @Override
    public InterfaceDAOPedidos getMockUpDAO() {

        AbstractRepository repository=repositories.get(0);

        if(repository != null)
            return repository.mockupDAO;
        else
            return null;
    }
}
