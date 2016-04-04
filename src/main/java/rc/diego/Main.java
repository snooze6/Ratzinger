package rc.diego;

import rc.diego.controller.TaskMapper;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.AbstractFactoryMySQL;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {



        TaskMapper tm=new TaskMapper();

//        VOCd cd = new VOCd();
//        cd.setId(10);
//
//        if (tm.getCd(cd)){
//            cd.setImage("http://2.bp.blogspot.com/-gc17vQRx0fM/UDXnKUHdhKI/AAAAAAAAAEs/wsihOY5wEoQ/s320/fmb-35081.gif");
//            if (tm.updateCd(cd)){
//                System.out.println("Yeha");
//            } else {
//                System.out.println("Nope");
//            }
//        }

//        VOCd cd2 = new VOCd();
//            cd2.setTitle("Gothic Lolita Propaganda");
//            cd2.setCountry("Japan");
//            cd2.setImage("http://www.game-ost.com/static/covers_soundtracks/1/4/14080_558869.jpg");
//            cd2.setQuantity(100);
//            cd2.setDescription("All heil Yui-sama");
//            cd2.setAuthor("Yousei Teikoku");
//            cd2.setUnitaryPrice(15.99f);
//
//        tm.createCd(cd2);

//        ArrayList<VOUser> users = tm.getAllUsers();
//        for (int i=0; i<users.size(); i++){
//            System.out.println(users.get(i).toString());
//        }

//        VOUser user = new VOUser();
//        user.setDNI("12345678Z");
//        tm.deactivateUser(user);

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
