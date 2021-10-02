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
 * The persistent class for the authorities database table.
 * 
 */
@Entity
@Table(name="authorities")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 4168491494286310132L;

	@Id
	@SequenceGenerator(name="authoritiesSequence", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="authoritiesSequence")
	private Integer id;

	@Column(name="authority_name")
	private String authorityName;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to RolesAuthority
	@OneToMany(mappedBy="authority")
	private Set<RolesAuthority> rolesAuthorities;

	public Authority() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
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
		rolesAuthority.setAuthority(this);

		return rolesAuthority;
	}

	public RolesAuthority removeRolesAuthority(RolesAuthority rolesAuthority) {
		getRolesAuthorities().remove(rolesAuthority);
		rolesAuthority.setAuthority(null);

		return rolesAuthority;
	}

}