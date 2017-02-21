package com.library.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.entity.Book;
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
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public String login(@ModelAttribute("book") Book book, Model model, @RequestParam(value="picture", required=true) MultipartFile picture, @RequestParam(value="filePdf", required=true) MultipartFile bookFile){
//		if(bindingResult.hasErrors()){
//			model.addAttribute("errors",  bindingResult.getAllErrors());
//			return "addBook";
//		}
		File img = new File("Pictures\\picture\\" + book.getIsbn() + "image.jpg");
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
		File file = new File("Pictures\\file\\" + book.getIsbn() + "file.pdf");
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
//		book.setId(1);
		libraryService.addBook(book);
		model.addAttribute("books", libraryService.getBooksByGenre(book.getGenre().getId()));
		return "redirect:/library";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/editBook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model){		
		model.addAttribute("book", libraryService.getBookById(id));
		model.addAttribute("genres", libraryService.getAllGenre());
		return "addBook";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/editBook/{id}", method = RequestMethod.POST)
	public String editBook(@ModelAttribute("book") Book book, Model model, @RequestParam(value="picture", required=true) MultipartFile picture, @RequestParam(value="filePdf", required=true) MultipartFile bookFile){
		File img = new File("Pictures\\picture\\" + book.getIsbn() + "image.jpg");
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
		File file = new File("Pictures\\file\\" + book.getIsbn() + "file.pdf");
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
//		book.setId(1);
		libraryService.addBook(book);
		model.addAttribute("books", libraryService.getBooksByGenre(book.getGenre().getId()));
		return "redirect:/library";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/picture_book/{name}", method = RequestMethod.GET)
	public void showPicture(@PathVariable("name") String name, HttpServletResponse response, HttpServletRequest request){
		try {
			response.setContentType("image/jpg");
			InputStream is = null;
			if(name != null){
				is = new FileInputStream(new File("Pictures\\picture\\" + name + ".jpg"));
			}else{
				is = new FileInputStream(new File("Pictures\\picture\\noImgBook.png"));
			}
			response.getOutputStream().write(IOUtils.toByteArray(is));
			response.getOutputStream().close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/deleteBook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model){
		libraryService.deleteBookById(id);
		model.addAttribute("books", libraryService.getBooksByGenre(1L));
		model.addAttribute("genres", libraryService.getAllGenre());
		return "redirect:/library";
	}
}
