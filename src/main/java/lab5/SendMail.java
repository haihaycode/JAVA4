package lab5;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static String send(String to, String subject, String messageText) {
		// thiết lập

		final String username = "kienthuc177@gmail.com";
		final String password = "plro oiif kykq plmj";
		String mess = "";

		// cấu hình
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");// TLS
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// Tạo đối tượng Session để xác thực
		// đăng nhập
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Tạo đối tượng MimeMessage
			// một đối tượng được sử dụng để đại diện cho một email trong JavaMail API.
			MimeMessage message = new MimeMessage(session);

			// Thiết lập người gửi, người nhận và tiêu đề
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);

			// Thiết lập nội dung của email
			message.setText(messageText);

			// Gửi email
			Transport.send(message);

			// Redirect hoặc hiển thị thông báo thành công
			mess = "Gửi mail thành công";
		} catch (MessagingException mex) {
			System.out.println(mex.getMessage());
			mess = "Gửi mail thất bại";
		}
		return mess;
	}
}
