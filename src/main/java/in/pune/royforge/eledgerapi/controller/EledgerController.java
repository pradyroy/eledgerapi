package in.pune.royforge.eledgerapi.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author pradyroy
 *
 */

@RestController
@RequestMapping("/eledgerapi")
public class EledgerController {	
		
	@RequestMapping(value="heartbeat",method = RequestMethod.GET)
	public String heartbeat() {
		String currentDateOfTheServer = new Date().toString();
		return currentDateOfTheServer;
	}

}