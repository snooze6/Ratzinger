package rc.diego.model.utils.mail;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;

import java.text.DecimalFormat;
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
                }
        );

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Confirmación de compra");

            final float[] total = {0};

            StringBuilder texto=new StringBuilder();
            texto.append("Hola "+user.getFirstName()+","
                    + "\n\nEste es un correo con el resumen de su compra. Por favor, no responda a este correo" +
                    "\n\nProductos comprados: <table><tr>"+
                    "<th>Producto</th>"+
                    "<th>Cantidad</th>"+
                    "<th>Precio</th>" +
                    "</tr>");

            cart.forEach((integer, voCd) -> {
                texto.append("<tr>"+
                        "<td>"+voCd.getTitle()+"</td>"+
                        "<td>"+voCd.getQuantity()+"</td>"+
                        "<td>"+voCd.getUnitaryPrice()+"€</td>"+
                        "</tr>");
                total[0] +=voCd.getQuantity()*voCd.getUnitaryPrice();
            });

            texto.append("</table>");

            if(user.isVip()) {
                texto.append("\n\nDescuento VIP(20%): "+ new DecimalFormat("#.##").format(total[0] * 0.8F)+"€ ");
                texto.append("\n\nTotal+IVA(21%): "+ new DecimalFormat("#.##").format(total[0] * 0.8F * 1.21)+"€ ");
            }else{

            }
            message.setContent(texto.toString(), "text/html; charset=utf-8");

            Transport.send(message);

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