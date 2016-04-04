package rc.diego;

import rc.diego.controller.TaskMapper;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.AbstractFactoryMySQL;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {




/*        TaskMapper tm=new TaskMapper();
        VOUser user=new VOUser();
        user.setDNI("12345678Z");
        user.setPassword("test");

        tm.setUserData(
                user.getDNI(),
                null,
                null,
                null,
                user.getPassword(),
                user
        );

        if(tm.signInUser(user)){  //usuario logueado correctamente
            System.out.println("Existe o usuario");
        }*/
       AbstractFactoryMySQL daoFactory = new AbstractFactoryMySQL();
        VOCd cd = new VOCd();
        cd.setId(1);
        try {
            daoFactory.getDAOComments().getCommentsByProduct(cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // daoFactory.getDAOCds().getAllCDs();

    }

}
