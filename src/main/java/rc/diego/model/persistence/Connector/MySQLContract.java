package rc.diego.model.persistence.Connector;

/**
 * Created by entakitos on 8/03/16.
 */
public class MySQLContract {
    final static String DATABASE_NAME = "";

    public static class Users{
        public static String TABLE_NAME="users";
        public static String DNI = "DNI";
        public static String firstName = "firstName";
        public static String lastName = "lastName";
        public static String mail = "mail";
        public static String password = "password";
    }

    public static class Products{
        public static String TABLE_NAME="products";
        public static String ID="id";
        public static String NAME="name";
        public static String DESCRIPTION="description";
        public static String AUTHOR="author";
        public static String COUNTRY="country";
        public static String UNITARY_PRICE="unitary_price";
        public static String QUANTITY="quantity";
    }

    public static class Orders{
        public static String TABLE_NAME="orders";
        public static String ID="id";
        public static String USER="user";
        public static String EMAIL="email";
        public static String TOTAL="total";
        public static String DATE="date";
    }

    public static class OrderProducsts{
        public static String TABLE_NAME="order_product";
        public static String ID_ORDER="idorder";
        public static String ID_PRODUCT="idproduct";
        public static String UNITARY_PRICE="unitaryPrice";
        public static String QUANTITY="quantity";
    }
}
