package pe.com.ncquality.sad.service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import pe.com.ncquality.sad.dto.ConfiguracionCorreo;



@Service("asincronoService")
public class AsincronoService {
	private static Logger depurador = Logger.getLogger(AsincronoService.class.getName());
	
	@Async
	public void envioCorreoAdjunto(ConfiguracionCorreo configuracionCorreo, String[] sMailTo, String sSubject, String sMailText,String[] archivo) throws MessagingException {
		depurador.info("envioCorreoAdjunto ==>");
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			// PRODUCCION
			//props.put("mail.smtp.starttls.enable", "false");
			// DESARROLLO
		    props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.enable", "false");
			props.put("mail.smtp.host", configuracionCorreo.getHost());
			props.put("mail.smtp.port", configuracionCorreo.getPuerto());
			props.put("mail.smtp.ssl.trust", configuracionCorreo.getHost());

			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(configuracionCorreo.getUsuario(), configuracionCorreo.getClave());
				}
			});
			
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
			
			message.setFrom(configuracionCorreo.getUsuario());
			message.setRecipients(MimeMessage.RecipientType.TO, to);
			message.setSubject(sSubject);
			message.setContent(multiParte);
			Transport.send(message);

			depurador.info("Mail Sent Successfully.");
         }catch (Exception e) {
             depurador.error("Error in Sending Mail: "+e);
         }
     }
}
