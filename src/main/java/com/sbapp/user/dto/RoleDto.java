package com.sbapp.user.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * This class used for the data transfer object for Role.
 * 
 */
public class RoleDto implements Serializable {
	private static final long serialVersionUID = -3656644400604386365L;
	
	private Integer id;
	private String createdBy;
	private Date createdDate;
	private String roleName;
	private String updatedBy;
	private Date updatedDate;

	public RoleDto() {
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

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}