package com.praxctice.CouMod.Modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.praxctice.CouMod.Course.CourseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ModulesEntity {
	public ModulesEntity() {}
	public ModulesEntity(int modid, String modname, int duration, CourseEntity course) {
		super();
		Modid = modid;
		Modname = modname;
		this.duration = duration;
		this.course = course;
	}

	@Id
	private int Modid;
	private String Modname;
	private int duration;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CourseEntity course;

	public int getModid() {
		return Modid;
	}

	public void setModid(int modid) {
		Modid = modid;
	}

	public String getModname() {
		return Modname;
	}

	public void setModname(String modname) {
		Modname = modname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}
}
