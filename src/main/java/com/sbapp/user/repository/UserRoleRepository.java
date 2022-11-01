/**
 * 
 */
package com.sbapp.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sbapp.user.model.User;
import com.sbapp.user.model.UsersRole;

/**
 * @author user
 *
 */

@Repository
@RepositoryRestResource(path = "user-role-export", exported = true)
public interface UserRoleRepository extends JpaRepository<UsersRole, Integer> {
	Optional<List<UsersRole>> findByUser(User user);
}
