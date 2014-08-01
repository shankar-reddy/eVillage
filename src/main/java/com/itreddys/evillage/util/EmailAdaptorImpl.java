/**
 * Author : Sankara Reddy Telukutla
 * Jul 19, 2014  10:11:38 PM
 * 
 */
package com.itreddys.evillage.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
public class EmailAdaptorImpl implements EmailAdaptor {
	private static final Logger logger_c = Logger.getLogger(EmailAdaptorImpl.class);
	EmailProperties emailProps;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itreddys.evillage.util.EmailAdaptor#sendMail(com.itreddys.evillage
	 * .util.EmailMessage)
	 */
	@Override
	public String sendMail(EmailMessage emailMessage) throws eVillageException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", emailProps.getHost());
		props.put("mail.smtp.port", emailProps.getPort());

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailProps
								.getSender(), emailProps.getPassword());
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailProps.getSender()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailMessage.getReceiver()));
			message.setSubject(emailMessage.getSubject());
			message.setText(emailMessage.getMessage());

			Transport.send(message);

			logger_c.info("Mail Sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	/**
	 * @return the emailProps
	 */
	public EmailProperties getEmailProps() {
		return emailProps;
	}

	/**
	 * @param emailProps the emailProps to set
	 */
	public void setEmailProps(EmailProperties emailProps) {
		this.emailProps = emailProps;
	}

}
