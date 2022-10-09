package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
///Hibernate k objectes ka page jo bd me save krana hai iski help se

@Entity
public class Note {
	
	@Id
private int id;///Id ki value Auto Increment nhi lege java.utill se random class me limit de dege

private String title;
@Column(length=4000)//ab is content me itne word dal skte hai
private String content;
private Date addedDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getAddedDate() {
	return addedDate;
}
public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}
public Note() {
	super();
	// TODO Auto-generated constructor stub
}
public Note( String title, String content, Date addedDate) {
	super();
	this.id = new Random().nextInt(10000);
	this.title = title;
	this.content = content;
	this.addedDate = addedDate;
}

}
