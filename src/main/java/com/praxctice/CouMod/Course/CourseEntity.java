package com.praxctice.CouMod.Course;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.praxctice.CouMod.Modules.ModulesEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class CourseEntity {
	@Id
	@Column(nullable = false)
	private int id;
	private String  Name;
	private String  Incharge;
	private int amount;
	private int duration;
	private LocalDateTime created;
	private LocalDateTime updated;
	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private List<ModulesEntity> entity;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIncharge() {
		return Incharge;
	}
	public void setIncharge(String incharge) {
		Incharge = incharge;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setEntity(List<ModulesEntity> entity) {
		this.entity = entity;
	}
	public List<ModulesEntity> getEntity() {
		return entity;
	}
	@PrePersist
	public void persisting() {
		LocalDateTime now = LocalDateTime.now();
		this.setCreated(now);
		this.setUpdated(now);
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	@PreUpdate
	public void updating() {
		this.updated=LocalDateTime.now();
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	
}
