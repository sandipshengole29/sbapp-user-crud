package com.sbapp.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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

	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="role_name")
	private String roleName;

	@Column(name="updated_by")
	private String updatedBy;

	@UpdateTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

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

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date();
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

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = new Date();
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

	@PreUpdate
	public void setUpdatedDate() {
		this.updatedDate = new Date();
	}
	
	@PrePersist
	public void setCreatedDate() {
		this.createdDate = new Date();
	}
}