package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public abstract class AbstractRepository extends AbstractALLDAOs{

    //ABSTRACT METHODS
    abstract void initializeData();


    //INNER CLASS
    public enum RepositoryType {
        UNKNOW,CACHE,LOCAL,REMOTE;
    }

    //PROPERTIES
    private RepositoryType type;

    //IMPLEMENTED METHODS
    public AbstractRepository() {
        this.type = RepositoryType.UNKNOW;
        initializeData();
    }

}