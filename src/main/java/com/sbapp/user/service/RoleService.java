/**
 * 
 */
package com.sbapp.user.service;

import com.sbapp.user.dto.RoleDto;
import com.sbapp.user.model.Role;

/**
 * @author Sandip
 * @category Role Service Interface
 * @apiNote Used in managing the role information
 *
 */
public interface RoleService {
	public Role saveNewRole(RoleDto roleDto);
	public RoleDto editRole(Integer roleId);
	public Role updateRole(RoleDto roleDto);
	public Integer deleteRole(Integer roleId);
}
