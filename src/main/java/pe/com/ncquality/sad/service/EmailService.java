package pe.com.ncquality.sad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import pe.com.ncquality.sad.dto.Parametro;
import pe.com.ncquality.sad.thread.EmailSendMessageThread;


@Service("iEmailService")
public class EmailService {
	private static Logger depurador = Logger.getLogger(EmailService.class.getName());
	private String SERVMAIL_HOST = "";
	private String SERVMAIL_PORT = "";
	private String SERVMAIL_USUARIO = "";
	private String SERVMAIL_PASSWORD = "";

	public Session getMailSession() {
		depurador.info(":::::::::::::::::::: getMailSession :::::::::::::::::::::::");
		List<Parametro> parametrocorreo = new ArrayList<Parametro>();
		// parametrocorreo = iMaestroDao.getParametrosServidorCorreos("SERVMAIL_");
		for (int i = 0; i < parametrocorreo.size(); i++) {
			if (parametrocorreo.get(i).getCnompar().equals("SERVMAIL_HOST")) {
				SERVMAIL_HOST = parametrocorreo.get(i).getCdescripcion();
			}

			if (parametrocorreo.get(i).getCnompar().equals("SERVMAIL_PORT")) {
				SERVMAIL_PORT = parametrocorreo.get(i).getCdescripcion();
			}

			if (parametrocorreo.get(i).getCnompar().equals("SERVMAIL_USUARIO")) {
				SERVMAIL_USUARIO = parametrocorreo.get(i).getCdescripcion();
			}

			if (parametrocorreo.get(i).getCnompar().equals("SERVMAIL_PASSWORD")) {
				SERVMAIL_PASSWORD = parametrocorreo.get(i).getCdescripcion();
			}
		}

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		// PRODUCCION
		props.put("mail.smtp.starttls.enable", "false");
		// DESARROLLO
		// props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.host", SERVMAIL_HOST);
		props.put("mail.smtp.port", SERVMAIL_PORT);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SERVMAIL_USUARIO, SERVMAIL_PASSWORD);
			}
		});
		return session;
	}

	public void sendMessageWithAttachment(String from, String[] sMailTo, String sSubject, String sMailText,String[] archivo)
			throws MessagingException {
		try {
			Session mailSession = getMailSession();
			EmailSendMessageThread correo = new EmailSendMessageThread(mailSession, SERVMAIL_USUARIO, sMailTo, sSubject, sMailText, archivo);
			correo.start();

		} catch (Exception e) {
			depurador.error(null, e);
		}
	}

	
}
