package com.booksystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.booksystem.model.Book;

public class Dao {

	public int addBook(String title, String publisher, String writer, int year)
			throws SQLException {
		String query = "INSERT INTO Book (TITLE,WRITER,PUBLISHER,PUBLISHED_YEAR) Values('"
				+ title
				+ "','"
				+ writer
				+ "','"
				+ publisher
				+ "',"
				+ year
				+ ");";
		int result = SqlConnector.executeUpdateQuery(query);
		return result;
	}

	public List<Book> getBookRecords() throws SQLException {
		List<Book> book = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK";
		ResultSet result = SqlConnector.executeQuery(query);
		while (result.next()) {
			book.add(new Book(result.getInt("ID"), result.getString("TITLE"),
					result.getString("WRITER"), result.getString("PUBLISHER"),
					result.getInt("PUBLISHED_YEAR")));
		}
		return book;
	}

	public List<Book> getBookByTitle(String title) throws SQLException {
		String query = "Select * from book Where TITLE = '" + title + "'";
		List<Book> book = new ArrayList<Book>();
		ResultSet result = SqlConnector.executeQuery(query);
		while (result.next()) {
			book.add(new Book(result.getInt("ID"), result.getString("TITLE"),
					result.getString("WRITER"), result.getString("PUBLISHER"),
					result.getInt("PUBLISHED_YEAR")));
		}
		return book;
	}

	public int updateBook(String title, int year) throws SQLException {
		String query = " UPDATE BOOK SET PUBLISHED_YEAR = " + year
				+ " WHERE TITLE = '" + title + "';";
		int result = SqlConnector.executeUpdateQuery(query);
		return result;
	}

	public int deleteAnItemFromBooks(String id) throws SQLException {
		String query = " DELETE from BOOK where ID =" + id;
		int result = SqlConnector.executeUpdateQuery(query);
		return result;
	}

	public int deleteAllRecord() throws SQLException {
		String query = "TRUNCATE table Book";
		int result = SqlConnector.executeUpdateQuery(query);
		return result;
	}
}
