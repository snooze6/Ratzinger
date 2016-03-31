package rc.diego.model.task;

import rc.diego.model.VO.VOUser;

/**
 * Created by entakitos on 29/02/16.
 */
public class setUserData implements InterfaceTask{

    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private VOUser VOUser;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VOUser getVOUser() {
        return VOUser;
    }

    public void setVOUser(VOUser VOUser) {
        this.VOUser = VOUser;
    }

    public setUserData(String dni, String firstName, String lastName, String email, String password, VOUser VOUser) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.VOUser = VOUser;
    }

    @Override
    public void run() {
        VOUser.setDNI(dni);
        VOUser.setFirstName(firstName);
        VOUser.setLastName(lastName);
        VOUser.seteMail(email);
        VOUser.setPassword(password);
    }
}
