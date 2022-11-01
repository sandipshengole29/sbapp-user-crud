/**
 * 
 */
package com.sbapp.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sbapp.user.model.Authority;

/**
 * @author user
 *
 */

@Repository
@RepositoryRestResource(path = "authority-export", exported = true)
public interface UserRepository extends JpaRepository<Authority, Integer> {
	Optional<Authority> findById(Integer id);
	
	Optional<Authority> findByAuthorityName(String authorityName);
}
