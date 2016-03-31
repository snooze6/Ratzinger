package rc.diego;

import rc.diego.controller.TaskMapper;
import rc.diego.model.VO.VOUser;

public class Main {

    public static void main(String[] args) {

        System.out.println(new TaskMapper().getAllCds());

        VOUser user=new VOUser();
        user.setDNI("53481946B");
        user.setFirstName("Diego");
        user.setLastName("Reiriz Cores");
        user.seteMail("diegoreiriz@asdasd.com");
        user.setPassword("abcdefg");

        new TaskMapper().signUpUser(user);
    }

}
