package com.sbapp.user.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 2955742045026409081L;

	@Id
	@SequenceGenerator(name="rolesSequence", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rolesSequence")
	private Integer id;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="role_name")
	private String roleName;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to RolesAuthority
	@OneToMany(mappedBy="role")
	private Set<RolesAuthority> rolesAuthorities;

	//bi-directional many-to-one association to UsersRole
	@OneToMany(mappedBy="role")
	private Set<UsersRole> usersRoles;

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<RolesAuthority> getRolesAuthorities() {
		return this.rolesAuthorities;
	}

	public void setRolesAuthorities(Set<RolesAuthority> rolesAuthorities) {
		this.rolesAuthorities = rolesAuthorities;
	}

	public RolesAuthority addRolesAuthority(RolesAuthority rolesAuthority) {
		getRolesAuthorities().add(rolesAuthority);
		rolesAuthority.setRole(this);

		return rolesAuthority;
	}

	public RolesAuthority removeRolesAuthority(RolesAuthority rolesAuthority) {
		getRolesAuthorities().remove(rolesAuthority);
		rolesAuthority.setRole(null);

		return rolesAuthority;
	}

	public Set<UsersRole> getUsersRoles() {
		return this.usersRoles;
	}

	public void setUsersRoles(Set<UsersRole> usersRoles) {
		this.usersRoles = usersRoles;
	}

	public UsersRole addUsersRole(UsersRole usersRole) {
		getUsersRoles().add(usersRole);
		usersRole.setRole(this);

		return usersRole;
	}

	public UsersRole removeUsersRole(UsersRole usersRole) {
		getUsersRoles().remove(usersRole);
		usersRole.setRole(null);

		return usersRole;
	}

}