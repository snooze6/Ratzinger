package rc.diego.model.utils.mail;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by entakitos on 3/04/16.
 */

public class JavaMail {

    private final String from = "dawatest4@gmail.com";
    private final String username = "dawatest4@gmail.com";//change accordingly
    private final String password = "4testdawa";//change accordingly

    private final Properties props = new Properties();

    public void sendMail(String to, VOUser user, VOShoppingCart cart) {
        // Recipient's email ID needs to be mentioned.

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Confirmación de compra");

            StringBuilder texto=new StringBuilder();
            texto.append("Hola "+user.getFirstName()+","
                    + "\n\n Este es un correo con el resumen de su compra. Por favor, no responda a este correo" +
                    "\n\nProductos comprados:" +
                    "\nProducto"+
                    "\tCantidad"+
                    "\tPrecio");

            cart.forEach((integer, voCd) -> {
                texto.append("\n"+voCd.getTitle()+
                        "\t"+voCd.getQuantity()+
                        "\t"+voCd.getUnitaryPrice());
            });

            message.setText(texto.toString());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public JavaMail() {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

    }
}