package com.sbapp.user.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * This class used for the data transfer object for UsersRole.
 * 
 */
public class UsersRole implements Serializable {
	private static final long serialVersionUID = -8403016783688355214L;
	
	private Integer id;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private Integer roleId;
	private Integer userId;

	public UsersRole() {
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

	public Integer getRole() {
		return this.roleId;
	}

	public void setRole(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUser() {
		return this.userId;
	}

	public void setUser(Integer userId) {
		this.userId = userId;
	}

}