package rc.diego;

import rc.diego.controller.TaskMapper;
import rc.diego.model.VO.VOUser;

public class Main {

    public static void main(String[] args) {

        TaskMapper tm=new TaskMapper();
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
        }


    }

}
