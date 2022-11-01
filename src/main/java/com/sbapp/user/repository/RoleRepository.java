/**
 * 
 */
package com.sbapp.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sbapp.user.model.Role;

/**
 * @author user
 *
 */

@Repository
@RepositoryRestResource(path = "role-export", exported = true)
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findById(Integer id);
	
	Optional<Role> findByRoleName(String roleName);
}
