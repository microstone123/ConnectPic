package com.tea.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author linhs
 * @date: 2015年9月6日 上午9:52:33
 * @Description: TODO(指令库)
 */

@Table(name = "tb_instruct")
public class InstructInfo {

	@Id
	private Integer id;

	@Column(column = "instructName")
	private String instructName;

	@Column(column = "instructValue")
	private String instructValue;

	@Column(column = "instructType")
	private Integer instructType;

	@Column(column = "instructRemark")
	private String instructRemark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstructName() {
		return instructName;
	}

	public void setInstructName(String instructName) {
		this.instructName = instructName;
	}

	public String getInstructValue() {
		return instructValue;
	}

	public void setInstructValue(String instructValue) {
		this.instructValue = instructValue;
	}

	public Integer getInstructType() {
		return instructType;
	}

	public void setInstructType(Integer instructType) {
		this.instructType = instructType;
	}

	public String getInstructRemark() {
		return instructRemark;
	}

	public void setInstructRemark(String instructRemark) {
		this.instructRemark = instructRemark;
	}

}
