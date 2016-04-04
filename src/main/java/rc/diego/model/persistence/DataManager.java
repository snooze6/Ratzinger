package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.MySQL.AbstractFactoryMySQL;
import rc.diego.model.persistence.MySQL.DAOUsersMySQL;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by entakitos on 4/04/16.
 */
public abstract class DataManager{
    
    //private static List<AbstractDAOFactory> sources;
    
    private static AbstractDAOFactory remote;

    private static HashMap<Integer,VOCd> cacheCds = new HashMap<>();
    private static boolean isCacheValid=false;

    private static boolean initialized=false;
    private static void initialiceManager(){

        remote = new AbstractFactoryMySQL();
    }

    /*-------------------*/
    /*      FACTORY      */
    /*-------------------*/

    public static InterfaceDAOPedidos getDAOPedidos(){
        if(!initialized) {
            initialiceManager();
            initialized=true;
        }

        return new FachadeDAOPedidos();
    }

    public static InterfaceDAOCds getDAOCds(){
        if(!initialized) {
            initialiceManager();
            initialized=true;
        }

        return new FachadeDAOCds();
    }


    public static InterfaceDAOUsers getDAOUsers(){
        if(!initialized) {
            initialiceManager();
            initialized=true;
        }

        return new FachadeDAOUsers();
    }


    /*-------------------*/
    /*    DAO PEDIDOS    */
    /*-------------------*/

    private static class FachadeDAOPedidos implements InterfaceDAOPedidos{
        @Override
        public boolean insertOrder(VOUser user, VOShoppingCart carrito) throws SQLException{
            return remote.getDAOPedidos().insertOrder(user,carrito);
        }
    }

    /*-------------------*/
    /*      DAO CDS      */
    /*-------------------*/

    private static class FachadeDAOCds implements InterfaceDAOCds{

        @Override
        public VOShoppingCart getAllCDs() {
            if(isCacheValid){
                VOShoppingCart cart=new VOShoppingCart();
                cart.putAll(cacheCds);
                return cart;
            }

            VOShoppingCart cart=remote.getDAOCds().getAllCDs();

            if(!isCacheValid){
                cacheCds.clear();
                cacheCds.putAll(cart);
                isCacheValid=true;
            }

            return cart;
        }

        @Override
        public boolean getCD(VOCd cd) {
            if(isCacheValid) {
                cd=cacheCds.get(cd.getId());
                return true;
            }

            return remote.getDAOCds().getCD(cd);
        }

        @Override
        public boolean updateCDQuantity(VOCd cd){

            if(remote.getDAOCds().updateCDQuantity(cd)) {
                if(isCacheValid)
                    cacheCds.replace(cd.getId(), cd);
                return true;
            }else
                return false;
        }

        @Override
        public boolean updateCD(VOCd cd){
            if(remote.getDAOCds().updateCD(cd)) {
                if(isCacheValid)
                    cacheCds.replace(cd.getId(), cd);
                return true;
            }else
                return false;

        }

        @Override
        public boolean create(VOCd cd){
            if(remote.getDAOCds().create(cd)){
                cacheCds.put(cd.getId(),cd);
                return true;
            }else{
                return false;
            }
        }

        @Override
        public boolean deleteCD(VOCd cd){
            if(remote.getDAOCds().deleteCD(cd)){
                cacheCds.remove(cd.getId());
                return true;
            }else{
                return false;
            }
        }
    }

    /*-------------------*/
    /*     DAO Users     */
    /*-------------------*/

    private static class FachadeDAOUsers implements InterfaceDAOUsers{
        @Override
        public void insertUser(VOUser user) throws SQLException, DAOUsersMySQL.UserAlreadyExistsException {
            remote.getDAOUsers().insertUser(user);
        }

        @Override
        public boolean getUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
            return remote.getDAOUsers().getUser(user);
        }

        @Override
        public boolean isAdmin(VOUser user) throws SQLException {
            return remote.getDAOUsers().isAdmin(user);
        }

        @Override
        public boolean isVip(VOUser user) throws SQLException {
            return remote.getDAOUsers().isVip(user);
        }

        @Override
        public boolean checkVipCondition(VOUser user) throws SQLException {
            return remote.getDAOUsers().checkVipCondition(user);
        }

        @Override
        public boolean makeVip(VOUser user) throws SQLException {
            return remote.getDAOUsers().makeVip(user);
        }

        @Override
        public ArrayList<VOUser> getUsers() throws SQLException {
            return remote.getDAOUsers().getUsers();
        }

        @Override
        public boolean updateUser(VOUser user) throws SQLException {
            return remote.getDAOUsers().updateUser(user);
        }

        @Override
        public boolean deleteUser(VOUser user) throws SQLException {
            return remote.getDAOUsers().deleteUser(user);
        }
    }
}
