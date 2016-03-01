package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public class CustomRepositoryManager extends AbstractRepositoryManager{

    @Override
    void initialRepositories() {
        addRepository(new MySqlRepository());
    }

    @Override
    void configRepositoriesPreferences() {

    }
}
