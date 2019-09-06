package com.booksystem.model;

public class Book {
	int id;
	String title;
	String publisher;
	String writer;
	int year;
	
	public Book(){
		
	}
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Book(int id, String title, String publisher, String writer, int year) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.year = year;
	}
	

}
