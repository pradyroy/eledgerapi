package in.pune.royforge.connection.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.connection.model.AuthRequest;
import in.pune.royforge.connection.model.LenderData;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.service.AuthenticationUserDetailsService;
import in.pune.royforge.connection.util.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class AuthorizationController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthenticationUserDetailsService authenticationUserDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("Invalid UserName/Password");
		}
		LenderData lender = authenticationUserDetailsService.getLenderDetails(authRequest.getUsername());
		return new ResponseEntity<>(
				new Response(new Date(), lender, jwtUtil.generateToken(authRequest.getUsername()), "success", HttpStatus.CREATED),
				HttpStatus.CREATED);
	}
}
