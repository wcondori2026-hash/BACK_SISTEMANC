package pe.com.ncquality.sad.thread;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jboss.logging.Logger;

public class EmailSendMessageThread extends Thread {
	private static Logger depurador = Logger.getLogger(EmailSendMessageThread.class.getName());
	private Session mailSession;
	private String from;
	private String[] sMailTo; 
	private String sSubject;
	private String sMailText;
	private String[] archivo;
	
	public EmailSendMessageThread(Session mailSession, String from, String[] sMailTo, String sSubject, String sMailText,String[] archivo) {
		this.mailSession = mailSession;
		this.from = from;
		this.sMailTo = sMailTo;
	    this.sSubject = sSubject;
	    this.sMailText = sMailText;
	    this.archivo = archivo;
	 }
	
	public void run() {
		try {
			sendMessageWithAttachment();
		} catch (Exception e) {
			depurador.error(null,e);
		}
	}
	
	public void sendMessageWithAttachment() throws MessagingException {
    	try {
			MimeMessage message = new MimeMessage(mailSession);
			
			Address[] to = new InternetAddress[sMailTo.length] ;
			for (int i = 0; i < sMailTo.length; i++) {
				to[i] = new InternetAddress(sMailTo[i]);
			}
			
			MimeMultipart multiParte = new MimeMultipart();
			
			MimeBodyPart texto = new MimeBodyPart();
			texto.setText(sMailText, null, "html");
			multiParte.addBodyPart(texto);
			MimeBodyPart adjunto = new MimeBodyPart();
			
			for (int i = 0; i < archivo.length; i++) {
				adjunto = new MimeBodyPart();
				adjunto.attachFile(archivo[i]);
				multiParte.addBodyPart(adjunto);
			}
			
			message.setFrom(this.from);
			message.setRecipients(MimeMessage.RecipientType.TO, to);
			message.setSubject(sSubject);
			message.setContent(multiParte);
			Transport.send(message);

			System.out.println("Mail Sent Successfully.");
         }catch (Exception e) {
        	 depurador.error("Error in Sending Mail: "+e);
         }
     }
	
}

