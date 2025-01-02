package com.praxctice.CouMod.Course;

public class Course {
  private int CourId;
  private String CourName;
  private String Incharge;
  private int amount;
  private int durationinmonths;
public int getCourId() {
	return CourId;
}

	
public void setCourId(int courId) {
	CourId = courId;
}
public String getCourName() {
	return CourName;
}
public void setCourName(String courName) {
	CourName = courName;
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
public int getDurationinmonths() {
	return durationinmonths;
}
public void setDurationinmonths(int durationinmonths) {
	this.durationinmonths = durationinmonths;
}
@Override
public String toString() {
	return "Course [CourId=" + CourId + ", CourName=" + CourName + ", Incharge=" + Incharge + ", amount=" + amount
			+ ", durationinmonths=" + durationinmonths + "]";
}
}
