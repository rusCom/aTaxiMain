import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailService {
    private String host = "";
    private int port = 0;
    private String username = "";
    private String password = "";
    private String from = "";


    public EmailService(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public EmailService(String host, int port, String username, String password, String from) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.from = from;
    }

    public void sendMail(String to, String subject, String body, String attachment) throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });



        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject(subject);

        if (!attachment.equals("")){
            Multipart multipart = new MimeMultipart();

            String[] attachments = attachment.split(";");
            for (int itemID = 0; itemID < attachments.length; itemID++) {
                String fileName = attachments[itemID];
                MimeBodyPart attachmentPart = new MimeBodyPart();
                DataSource source = new FileDataSource(fileName);
                attachmentPart.setDataHandler(new DataHandler(source));
                File f = new File(fileName);
                attachmentPart.setFileName(MimeUtility.encodeText(f.getName(), "UTF-8", null));
                multipart.addBodyPart(attachmentPart);
            }
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Thread.currentThread().setContextClassLoader( getClass().getClassLoader() );
        }
        else {
            message.setText(body);
        }
        Transport.send(message);

    }

}
