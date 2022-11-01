/**
 * 
 */
package com.sbapp.user.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbapp.user.dto.RoleDto;
import com.sbapp.user.model.Role;
import com.sbapp.user.repository.RoleRepository;

/**
 * @author Sandip
 * @category Role Service Interface implementation
 * @apiNote Used in managing the role service
 *
 */

@Service
public class RoleServiceImpl implements RoleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role saveNewRole(RoleDto roleDto) {
		Role newRole = new Role();
		LOGGER.info("--- save new information: {} ---", roleDto);
		newRole.setRoleName(roleDto.getRoleName());
		newRole.setCreatedBy("ADMIN");
		newRole.setUpdatedBy("ADMIN");
		newRole = roleRepository.save(newRole);
		return newRole;
	}
	
	@Override
	public RoleDto editRole(Integer roleId) {
		RoleDto roleDto = null;
		Optional<Role> newRole = null;
		LOGGER.info("--- edit role information: {} ---", roleId);
		newRole = roleRepository.findById(roleId);
		if(newRole.isPresent()) {
			roleDto = new RoleDto();
			roleDto.setRoleName(newRole.get().getRoleName());
			roleDto.setCreatedBy(newRole.get().getCreatedBy());
			roleDto.setCreatedDate(newRole.get().getCreatedDate());
			roleDto.setId(newRole.get().getId());
			roleDto.setUpdatedBy(newRole.get().getUpdatedBy());
			roleDto.setUpdatedDate(newRole.get().getUpdatedDate());
		}
		return roleDto;
	}
	
	@Override
	public Role updateRole(RoleDto roleDto) {
		Optional<Role> optionalRole = null;
		Role existingRole = null;
		LOGGER.info("--- update role information: {} ---", roleDto);
		optionalRole = roleRepository.findById(roleDto.getId());
		if(optionalRole.isPresent()) {
			existingRole = optionalRole.get();
			existingRole.setId(roleDto.getId());
			existingRole.setRoleName(roleDto.getRoleName());
			existingRole = roleRepository.save(existingRole);
		}else {
			existingRole = optionalRole.orElse(null);
		}
		return existingRole;
	}
	
	@Override
	public Integer deleteRole(Integer roleId) {
		Optional<Role> optionalRole = null;
		Role existingRole = null;
		Integer deleteRoleCount = 0;
		LOGGER.info("--- delete role information: {} ---", roleId);
		optionalRole = roleRepository.findById(roleId);
		if(optionalRole.isPresent()) {
			existingRole = optionalRole.get();
			roleRepository.delete(existingRole);
			deleteRoleCount = 1;
		} else {
			deleteRoleCount = 1;
		}
		return deleteRoleCount;
	}
}
