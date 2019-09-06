package com.booksystem.service;

import java.sql.SQLException;
import java.util.List;
import com.booksystem.dao.Dao;
import com.booksystem.model.Book;

public class Service {
	Dao daoObj = new Dao();

	public int addBook(String title, String publisher, String writer, int year) throws SQLException {
		int result = daoObj.addBook(title,publisher,writer,year);
		return result;
	}

	public List<Book> getBookRecords() throws SQLException {
		return 	daoObj.getBookRecords();
	}

	public List<Book> getBookByTitle(String title) throws SQLException {
		return daoObj.getBookByTitle(title);
	}

	public int updateBook(String title, int year) throws SQLException {
		return daoObj.updateBook(title,year);
	}

	public int deleteAnItemFromBooks(String id) throws SQLException {
		return daoObj.deleteAnItemFromBooks(id);
	}

	public int deleteAllRecord() throws SQLException {
		return daoObj.deleteAllRecord();
	}
}
