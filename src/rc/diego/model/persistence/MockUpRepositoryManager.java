package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public class MockUpRepositoryManager extends AbstractRepositoryManager{

    @Override
    void initialRepositories() {
        addRepository(new MockUpRepository());
    }

    @Override
    void configRepositoriesPreferences() {

    }
}
