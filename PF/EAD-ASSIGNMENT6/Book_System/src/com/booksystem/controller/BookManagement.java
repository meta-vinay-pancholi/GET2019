package com.booksystem.controller;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.booksystem.model.Book;
import com.booksystem.service.Service;
import com.google.gson.Gson;

@Path("/book")
public class BookManagement {
        Service serviceObject = new Service();
	@POST
	@Path("/insertBook")
	@Produces(MediaType.APPLICATION_JSON)
	public String addBook(Book book) {
		try {
			if (serviceObject.addBook(book.getTitle(), book.getPublisher(),
					book.getWriter(), book.getYear()) > 0) {
				return "Data Inserted";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error while adding the data" + "";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getBookRecords() {
		List<Book> book;
		try {
			book = serviceObject.getBookRecords();
			if (book.size() > 0) {
				Gson gson = new Gson();
				String bookJson = gson.toJson(book);
				return bookJson;
			} else {
				return "No Book Found";
			}
		} catch (SQLException e) {
			return e + "Error occured";
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{title}")
	public String getBookByTitle(@PathParam("title") String title) {
		Service serviceObject = new Service();
		List<Book> book;
		try {
			book = serviceObj.getBookByTitle(title);
			if (book.size() > 0) {
				Gson gson = new Gson();
				String inventoryJson = gson.toJson(book);
				return inventoryJson;
			} else {
				return "No Book Found";
			}
		} catch (SQLException e) {
			return e + "Error occured";
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{title}")
	public String updateBook(Book book, @PathParam("title") String title)
			throws SQLException {
		Service serviceObject = new Service();
		if (serviceObj.updateBook(title, book.getYear()) >= 1) {
			return "Data Updated";
		} else {
			return "There was an error while updating the data";
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{ID}")
	public String deleteAnItemFromBooks(@PathParam("ID") String ID)
			throws SQLException {
		Service serviceObject = new Service();
		if (serviceObj.deleteAnItemFromBooks(ID) >= 1) {
			return "Data Deleted";
		} else {
			return "There was an error while deleting the data";
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAllRecord() throws SQLException {
		Service serviceObject = new Service();
		if (serviceObject.deleteAllRecord() >= 1) {
			return "All data deleted";
		} else {
			return "There was an error while deleting the data";
		}
	}
}
