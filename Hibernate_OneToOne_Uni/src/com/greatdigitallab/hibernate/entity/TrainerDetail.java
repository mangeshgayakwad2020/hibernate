package com.greatdigitallab.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainer_detail")
public class TrainerDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="category")
	private String category;
	
	@Column(name="competency")
	private String competency;

	public TrainerDetail() {

	}

	public TrainerDetail(String category, String competency) {
		this.category = category;
		this.competency = competency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompetency() {
		return competency;
	}

	public void setCompetency(String competency) {
		this.competency = competency;
	}

	@Override
	public String toString() {
		return "TrainerDetail [id=" + id + ", category=" + category + ", competency=" + competency + "]";
	}
	
}
