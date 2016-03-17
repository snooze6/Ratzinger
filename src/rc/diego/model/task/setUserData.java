package rc.diego.model.task;

import rc.diego.model.VO.VOUser;

/**
 * Created by entakitos on 29/02/16.
 */
public class setUserData implements InterfaceTask{

    private String name;
    private String email;
    private VOUser VOUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VOUser getVOUser() {
        return VOUser;
    }

    public void setVOUser(VOUser VOUser) {
        this.VOUser = VOUser;
    }

    public setUserData(String name, String email, VOUser VOUser) {
        this.name = name;
        this.email = email;
        this.VOUser = VOUser;
    }

    @Override
    public void run() {
        VOUser.setName(name);
        VOUser.seteMail(email);
    }
}
