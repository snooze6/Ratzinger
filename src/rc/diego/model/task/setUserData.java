package rc.diego.model.task;

import rc.diego.model.entities.User;

/**
 * Created by entakitos on 29/02/16.
 */
public class setUserData implements InterfaceTask{

    private String name;
    private String email;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public setUserData(String name, String email, User user) {
        this.name = name;
        this.email = email;
        this.user = user;
    }

    @Override
    public void run() {
        user.setName(name);
        user.seteMail(email);
    }
}
