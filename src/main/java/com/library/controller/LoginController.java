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
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.entity.User;
import com.library.entity.enums.UserRoleEnum;
import com.library.service.SecurityService;
import com.library.service.UserService;
import com.library.validator.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="edit/{id}", method = RequestMethod.GET)
	public String singUp(@PathVariable("id") int id, Model model){
		if(id != 0){
			model.addAttribute("user", userService.findById(id));
		}else{
			model.addAttribute("user", new User());
		}
		 return "/singup";
	}
	
	@RequestMapping(value="singup", method = RequestMethod.GET)
	public String singUp(Model model){
			model.addAttribute("user", new User());
		 return "/singup";
	}
	
	@RequestMapping(value="/singup", method = RequestMethod.POST)
	public String singUp(@Valid @ModelAttribute("user") User userForm, BindingResult bindingResult, Model model, @RequestParam(value="pict", required=true) MultipartFile file){
//		 userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()){
			model.addAttribute("errors",  bindingResult.getAllErrors());
			 return "singup";
		}
		try {
			
				File img = new File("e:\\Pictures\\" + userForm.getUsername() + "image.jpg");
				if(img.exists()){
					img.delete();
				}
				img.createNewFile();
				OutputStream out = null;
				out = new BufferedOutputStream(new FileOutputStream(img));
				if(file.getBytes().length != 0){
					out.write(file.getBytes());
					userForm.setPicture(userForm.getUsername() + "image.jpeg");
				}else{				
					userForm.setPicture("noImage.jpeg");
				}
			    out.close();
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 userForm.setRole(UserRoleEnum.ROLE_USER);
		 userService.save(userForm);
//		 securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
		return "redirect:/login";
	}
	
//	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("userForm", new User());
		return "login";
	}	

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value={"/", "/library"}, method = RequestMethod.GET)
	public String welcome(Model model, HttpServletResponse response, HttpServletRequest request){
		model.addAttribute("user", userService.findByUsername(request.getUserPrincipal().getName()));
		return "library";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model){
		model.addAttribute("users", userService.findAllUsers());
		return "admin";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String admin(@PathVariable("id") int id, Model model){
		File img = new File("e:\\Pictures\\" + userService.findById(id).getPicture());
		if(img.exists()){
			img.delete();
		}
		userService.deleteById(id);
		model.addAttribute("users", userService.findAllUsers());
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/picture/{name}", method = RequestMethod.GET)
	public void showPicture(@PathVariable("name") String name, HttpServletResponse response, HttpServletRequest request){
		try {
			response.setContentType("image/jpg");
			InputStream is = null;
			if(name != null){
				is = new FileInputStream(new File("e:\\Pictures\\" + name + ".jpg"));
			}else{
				is = new FileInputStream(new File("e:\\Pictures\\noImg.png"));
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
	
}
