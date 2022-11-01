/**
 * Role rest controller for maintaining user related information and activity.
 */
package com.sbapp.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbapp.user.dto.RoleDto;
import com.sbapp.user.model.Role;
import com.sbapp.user.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author Sandip
 * @apiNote Role rest controller for maintaining role related information and activity.
 * @version 1.0
 * @category Roles Data
 *
 */

@RestController
@Api(tags = "Role Rest Controller")
@RequestMapping("/roleRest")
public class RoleRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleRestController.class);
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/welcome")
	private String welcomeApplication() {
		String welcomeString = "************ Role rest controller is reachable ************";
		LOGGER.info(welcomeString);
		return welcomeString;
	}
	
	@Operation(summary = "Save role information")
	@PostMapping(value = "/saveRole")
	private void saveRoleInformation(@RequestBody RoleDto roleDto) {
		Role newRole = null;
		LOGGER.info("input usersInfo: {}", roleDto);
		newRole = roleService.saveNewRole(roleDto);
		LOGGER.info("New Role Created: {}", newRole);
	}
}
