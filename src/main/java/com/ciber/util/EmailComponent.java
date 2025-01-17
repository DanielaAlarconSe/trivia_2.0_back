package com.ciber.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.ciber.dto.EmailNotificacionDto;

@Component
public class EmailComponent {

	static Logger logger = LoggerFactory.getLogger(EmailComponent.class);

	/* ENVIO DE CORREO ASPIRANTE */
	public static void enviarNotificacion(EmailNotificacionDto email) {
		enviarNotificacion(email, false);
	}

	public static void enviarNotificacion(EmailNotificacionDto email, boolean lanzarError) {

		MimeMessagePreparator messagePreparator = mimeMessage -> {

			MimeMessageHelper messageHelper2 = new MimeMessageHelper(mimeMessage);
			messageHelper2.setFrom("soporte@ciberseguridadenlinea.com");
			messageHelper2.setTo(email.getDestinatarioAspirante());
			messageHelper2.setSubject(email.getAsunto());

			String mje2 = build(email);
			messageHelper2.setText(mje2, true);

		};

		try {
			JavaMailSender emailSender = crearJavaMailSender();
			emailSender.send(messagePreparator);

		} catch (MailException e) {
			logger.error(email.toString());
			e.printStackTrace();

			if (lanzarError)
				throw e;
		}
	}

	private static String build(EmailNotificacionDto email) throws Exception {
		String plantillaCorreo = obtenerTextoDeArchivo(
				new ClassPathResource("static/plantilla_correo/correo_aspirante.html").getFile());

		plantillaCorreo = plantillaCorreo.replaceAll(":nombre", email.getAspiranteNombre());
		plantillaCorreo = plantillaCorreo.replaceAll(":entidad", email.getEntidadNombre());
		plantillaCorreo = plantillaCorreo.replaceAll(":usuario", email.getUsuario());
		plantillaCorreo = plantillaCorreo.replaceAll(":clave", email.getClave());
		plantillaCorreo = plantillaCorreo.replaceAll(":fecha", email.getFechaFinalizacion());
		plantillaCorreo = plantillaCorreo.replaceAll(":enlace", email.getEnlaceLogin());
		

		return plantillaCorreo;
	}

	/* ENVIO DE CORREO ENTIDAD */
	public static void enviarNotificacionEntidad(EmailNotificacionDto email) {
		enviarNotificacionEntidad(email, false);
	}

	public static void enviarNotificacionEntidad(EmailNotificacionDto email, boolean lanzarError) {

		MimeMessagePreparator messagePreparator = mimeMessage -> {

			MimeMessageHelper messageHelper2 = new MimeMessageHelper(mimeMessage);
			messageHelper2.setFrom("soporte@ciberseguridadenlinea.com");
			messageHelper2.setTo(email.getDestinatarioEntidad());
			messageHelper2.setSubject(email.getAsunto());

			String mje2 = build2(email);
			messageHelper2.setText(mje2, true);

		};

		try {
			JavaMailSender emailSender = crearJavaMailSender();
			emailSender.send(messagePreparator);

		} catch (MailException e) {
			logger.error(email.toString());
			e.printStackTrace();

			if (lanzarError)
				throw e;
		}
	}

	private static String build2(EmailNotificacionDto email) throws Exception {
		String plantillaCorreo = obtenerTextoDeArchivo(
				new ClassPathResource("static/plantilla_correo/correo_entidad.html").getFile());

		plantillaCorreo = plantillaCorreo.replaceAll(":nombre", email.getAspiranteNombre());
		plantillaCorreo = plantillaCorreo.replaceAll(":entidad", email.getEntidadNombre());
		plantillaCorreo = plantillaCorreo.replaceAll(":trivia", email.getCuestionarioNombre());
		plantillaCorreo = plantillaCorreo.replaceAll(":puntaje", email.getPuntaje());
		plantillaCorreo = plantillaCorreo.replaceAll(":fecha", email.getFechaRegistro());

		return plantillaCorreo;
	}

	private static String obtenerTextoDeArchivo(File file) {

		FileReader fr = null;
		BufferedReader br = null;
		String contenido = "";
		try {
			fr = new FileReader(file.getPath());
			br = new BufferedReader(fr);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				contenido += linea;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contenido;
	}

	private static JavaMailSender crearJavaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost("smtp.ipage.com"); // O el host SMTP de tu dominio
		mailSender.setPort(587); //587 O 465 si usas SSL
		mailSender.setUsername("soporte@ciberseguridadenlinea.com");
		mailSender.setPassword("Ciber*$2018");
		mailSender.setDefaultEncoding("UTF-8");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true"); // Cambia a "false" si usas SSL
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.ssl.trust", "smtp.ipage.com"); // Asegúrate de usar el host correcto

		mailSender.setJavaMailProperties(javaMailProperties);

		return mailSender;
	}

}
