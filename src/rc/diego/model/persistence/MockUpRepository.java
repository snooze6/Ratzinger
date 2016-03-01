package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public class MockUpRepository extends AbstractRepository {

    @Override
    void initializeData() {
        this.mockupDAO = new MockUpDAO();
    }
}
