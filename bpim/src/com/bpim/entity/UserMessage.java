package com.bpim.entity;

import java.sql.Timestamp;


/**
 * author Delgado
 */
public class UserMessage extends VoBase {
	private static final long serialVersionUID = 4105264296390309486L;
	private Long id;
	private Long receiverId;
	private Long senderId;
	private String messageContent;
	private boolean readed;
	private String senderName;
	private Timestamp sendTime;
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
	 * @return the receiverId
	 */
	public Long getReceiverId() {
		return receiverId;
	}
	/**
	 * @param receiverId the receiverId to set
	 */
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * @return the senderId
	 */
	public Long getSenderId() {
		return senderId;
	}
	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	/**
	 * @return the messageContent
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * @param messageContent the messageContent to set
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * @return the readed
	 */
	public boolean isReaded() {
		return readed;
	}
	/**
	 * @param readed the readed to set
	 */
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * @return the sendTime
	 */
	public Timestamp getSendTime() {
		return sendTime;
	}
	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	
}

