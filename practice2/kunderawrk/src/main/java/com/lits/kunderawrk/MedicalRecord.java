package com.lits.kunderawrk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medical_record", schema = "default@hbase_pu")
class MedicalRecord {
	
	@Id
    public byte[] id;

	@Column(name="type")
    public String type;

	@Column(name="description")
    public String description;

	@Column(name="date_performed")
    public Date date_performed;

	public MedicalRecord() {
	}
	
	public byte[] getId() {
		return id;
	}

	public void setId(byte[] id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_performed() {
		return date_performed;
	}

	public void setDate_performed(Date date_performed) {
		this.date_performed = date_performed;
	}   
}
