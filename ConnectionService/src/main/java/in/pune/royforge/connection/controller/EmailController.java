package in.pune.royforge.connection.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.connection.model.EmailData;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.service.IEmailService;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {
	private Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	private IEmailService emailService;

	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public ResponseEntity<Response> sendResetMail(@RequestBody EmailData emailData)
			throws MessagingException, NoSuchAlgorithmException {
		logger.info("calling /reset-password POST API");
		return new ResponseEntity<>(new Response(new Date(), "Recovery Email With OTP has been sent.",
				HttpStatus.CREATED, emailService.sendResetMail(emailData)), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/new-customer", method = RequestMethod.POST)
	public ResponseEntity<Response> sendAddUserMail(@RequestBody EmailData emailData)
			throws MessagingException, NoSuchAlgorithmException {
		logger.info("calling /new-customer POST API");
		return new ResponseEntity<>(
				new Response(new Date(), emailService.sendAddCustomerMail(emailData), HttpStatus.CREATED),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<Response> sendSignUpMail(@RequestBody EmailData emailData)
			throws MessagingException, NoSuchAlgorithmException {
		logger.info("calling /signup POST API");
		return new ResponseEntity<>(
				new Response(new Date(), emailService.sendSignupEmail(emailData), HttpStatus.CREATED),
				HttpStatus.CREATED);
	}
}
