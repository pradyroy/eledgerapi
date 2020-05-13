package in.pune.royforge.connection.service;

import javax.mail.MessagingException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.pune.royforge.connection.model.EmailData;

@FeignClient(name = "emailService", url = "http://localhost:8081/")
public interface IEmailService {

	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	String sendResetMail(EmailData emailData) throws MessagingException;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	String sendSignupEmail(EmailData emailData) throws MessagingException;

	@RequestMapping(value = "/new-customer", method = RequestMethod.POST)
	String sendAddCustomerMail(EmailData emailData) throws MessagingException;
}
