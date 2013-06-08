package com.bpim.entity;


/**
 * author Delgado
 */
public class UserGroup extends VoBase {
	private static final long serialVersionUID = 6364413621958613243L;
	private Long id;
	private String groupName;
	private Long groupLeaderId;
	private String groupDescription;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the groupLeaderId
	 */
	public Long getGroupLeaderId() {
		return groupLeaderId;
	}
	/**
	 * @param groupLeaderId the groupLeaderId to set
	 */
	public void setGroupLeaderId(Long groupLeaderId) {
		this.groupLeaderId = groupLeaderId;
	}
	/**
	 * @return the groupDescription
	 */
	public String getGroupDescription() {
		return groupDescription;
	}
	/**
	 * @param groupDescription the groupDescription to set
	 */
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	
	
	
}

