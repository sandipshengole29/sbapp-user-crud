/**
 * 
 */
package com.sbapp.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sbapp.user.model.Role;
import com.sbapp.user.model.RolesAuthority;

/**
 * @author user
 *
 */

@Repository
@RepositoryRestResource(path = "role-auth-export", exported = true)
public interface RoleAuthorityRepository extends JpaRepository<RolesAuthority, Integer> {
	Optional<List<RolesAuthority>> findByAuthority(Role role);
}
