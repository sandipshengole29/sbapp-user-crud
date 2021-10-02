/**
 * User rest controller for maintaining user related information and activity.
 */
package com.sbapp.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author Sandip
 * @apiNote User rest controller for maintaining user related information and activity.
 * @version 1.0
 * @category Users Data
 *
 */

@RestController
@Api(tags = "User Rest Controller")
@RequestMapping("/userRest")
public class UserRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	
	@GetMapping(value = "/welcome")
	private String welcomeApplication() {
		String welcomeString = "************ user rest controller is reachable ************";
		LOGGER.info(welcomeString);
		return welcomeString;
	}
}
