package seniordesign;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class SendMail {
    
    public void sendMail(String emailRecipent, String Subj, String Text)
    {
        final String fromEmail = "email@gmail.com";
        final String password = "gmailPassword";
        final String toEmail = emailRecipent;
        
        System.out.println("Email Start");
        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
        
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
            }
        };
		
        Session session = Session.getDefaultInstance(props, auth);
        
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail)); //your email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRecipent));
            message.setSubject(Subj);
            message.setText(Text);
            
            Transport.send(message);
            
            System.out.println("Message sent Successfully");
            
        }catch(Exception e){
            System.out.println("Message failed...");
            System.out.println(e);
            //Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
