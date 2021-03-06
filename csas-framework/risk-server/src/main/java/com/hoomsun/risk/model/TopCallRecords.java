/**
 * Copyright www.hoomsun.com 红上金融信息服务（上海）有限公司
 */
package com.hoomsun.risk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 作者：ywzou <br>
 * 创建时间：2018年1月31日 <br>
 * 描述：通话记录top-N 通話頻次
 */
@Document(collection = "RK_TOP_CALL_RECORDS")
public class TopCallRecords {
	@Id
	private String id;
	@Indexed
	private String idNumber;
	@Indexed
	private String phoneNum;
	@Indexed
	private String applyId;
	private Date createDate;
	private Date claimDate;
	@Indexed
	private String crId;
	private List<TopCall> records = new ArrayList<TopCall>();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public void addRecords(TopCall call) {
		records.add(call);
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public List<TopCall> getRecords() {
		return records;
	}

	public void setRecords(List<TopCall> records) {
		this.records = records;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrId() {
		return crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public class TopCall {
		@Id
		private String callPhone;// 通话电话
		private Integer callFrequency;// 通话频次

		public String getCallPhone() {
			return callPhone;
		}

		public void setCallPhone(String callPhone) {
			this.callPhone = callPhone;
		}

		public Integer getCallFrequency() {
			return callFrequency;
		}

		public void setCallFrequency(Integer callFrequency) {
			this.callFrequency = callFrequency;
		}
	}
}
