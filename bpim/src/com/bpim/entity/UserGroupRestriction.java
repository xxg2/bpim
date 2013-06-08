package com.bpim.entity;


/**
 * author Delgado
 */
public class UserGroupRestriction extends VoBase {
	private static final long serialVersionUID = -5654826616596204426L;
	private Long userd;
	private Long groupId;
	private Integer isLeader;
	public Integer getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
	}
	private String priviledge;
	/**
	 * @return the userd
	 */
	public Long getUserd() {
		return userd;
	}
	/**
	 * @param userd the userd to set
	 */
	public void setUserd(Long userd) {
		this.userd = userd;
	}
	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the priviledge
	 */
	public String getPriviledge() {
		return priviledge;
	}
	/**
	 * @param priviledge the priviledge to set
	 */
	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}
	
}

