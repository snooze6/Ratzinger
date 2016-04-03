package rc.diego;

import rc.diego.controller.TaskMapper;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;

public class Main {

    public static void main(String[] args) {



        TaskMapper tm=new TaskMapper();

        VOCd cd = new VOCd();
        cd.setId(10);

        if (tm.getCd(cd)){
            cd.setImage("http://2.bp.blogspot.com/-gc17vQRx0fM/UDXnKUHdhKI/AAAAAAAAAEs/wsihOY5wEoQ/s320/fmb-35081.gif");
            if (tm.updateCd(cd)){
                System.out.println("Yeha");
            } else {
                System.out.println("Nope");
            }
        }


    }

}
