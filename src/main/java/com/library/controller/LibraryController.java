package com.library.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.service.LibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(value="/addBook", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("genres", libraryService.getAllGenre());
		return "addBook";
	}
	
	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model, @RequestParam(value="pict", required=true) MultipartFile picture, @RequestParam(value="bookFile", required=true) MultipartFile bookFile){
		if(bindingResult.hasErrors()){
			model.addAttribute("errors",  bindingResult.getAllErrors());
			return "addBook";
		}
		File img = new File("e:\\Pictures\\picturebook" + book.getIsbn() + "image.jpg");
		if(img.exists()){
			img.delete();
		}
		try {
			img.createNewFile();
			OutputStream out = null;
			out = new BufferedOutputStream(new FileOutputStream(img));
			if(picture.getBytes().length != 0){
				out.write(picture.getBytes());
				book.setPicturePath(book.getIsbn() + "image.jpeg");
			}else{				
				book.setPicturePath("noImage.jpeg");
			}
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		File file = new File("e:\\Pictures\\filebook" + book.getIsbn() + "file.pdf");
		if(file.exists()){
			file.delete();
		}
		try {
			file.createNewFile();
			OutputStream out = null;
			out = new BufferedOutputStream(new FileOutputStream(file));
			if(bookFile.getBytes().length != 0){
				out.write(bookFile.getBytes());
				book.setBookPath(book.getIsbn() + "file.pdf");
			}else{				
				book.setBookPath("noFile.pdf");
			}
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		libraryService.addBook(book);
		model.addAttribute("books", libraryService.getAllBooks());
		return "library";
	}
	
	@RequestMapping(value="/editBook/{id}", method = RequestMethod.GET)
	public String login(@PathVariable("id") int id, Model model){
		model.addAttribute("book", libraryService.getBookById(id));
		model.addAttribute("genres", libraryService.getAllGenre());
		return "addBook";
	}	
}
