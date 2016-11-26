package com.lits.kunderawrk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "physician", schema = "default@hbase_pu")
public class Physician {

	@Id
    public byte[] id;

	@Column(name="full_name")
    public String full_name;

	@Column(name="clinic_name")
    public String clinic_name;

	@Column(name="specialization")
    public String specialization;
	
	public Physician() {
	}

	public byte[] getId() {
		return id;
	}

	public void setId(byte[] id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
