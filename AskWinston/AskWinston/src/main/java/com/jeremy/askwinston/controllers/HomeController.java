package com.jeremy.askwinston.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeremy.askwinston.models.Dinner;
import com.jeremy.askwinston.models.User;
import com.jeremy.askwinston.services.DinnerService;
import com.jeremy.askwinston.services.UserService;
import com.jeremy.askwinston.validator.UserValidator;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  UserValidator validators;
	
	@Autowired
	private DinnerService dinnerService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validators.validate(user, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else {
			User newUser=userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/ask";

		}
	}
	
	@PostMapping("/login") 
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(userService.authenticateUser(email, password)) {
			User user=userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/ask";
		}
		redirectAttributes.addFlashAttribute("error", "Invaild Email and/or Password");
		 return "redirect:/";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/ask")
	public String ask() {
		return "ask.jsp";
	}
	
	@GetMapping("/dinners")
	public String dinner(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			List<Dinner> dinner = this.dinnerService.allDinner();
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("dinner", dinner);
			model.addAttribute("user", user);
			return "dinners.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/dinners/new")
	public String index(@ModelAttribute("newDinner") Dinner dinner) {
		return "new.jsp";
	}
	
	@PostMapping("/dinners/create")
	public String create(@Valid @ModelAttribute("newDinner") Dinner dinner, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			dinnerService.createDinner(dinner);
			return "redirect:/dinners";
		}
	}
	
	@GetMapping("/dinners/dinner/{id}")
	public String dinner(@PathVariable("id") Long dinnerId, Model model, HttpSession session) {
		Dinner dinner = dinnerService.getOneDinner(dinnerId);
		model.addAttribute("dinner", dinner);
		model.addAttribute("userLoggedIn",(Long)session.getAttribute("userId"));
		return "dinner.jsp";
	}
	
	@GetMapping("/dinners/delete/{id}")
	private String deleteDinner(@PathVariable("id") Long id) {
		dinnerService.deleteDinner(id);
		return "redirect:/dinners";
	}
	
	@GetMapping("/dinners/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("editedDinner") Dinner dinner, Model model) {
		Dinner editDinner = dinnerService.getOneDinner(id);
		model.addAttribute("editDinner", editDinner);
		return "edit.jsp";
	}
	
	@PostMapping("/dinners/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("editedDinner") Dinner dinner, BindingResult result, Model model) {
		if (result.hasErrors()) {
			Dinner editDinner = dinnerService.getOneDinner(id);
			model.addAttribute("editDinner", editDinner);
			return "edit.jsp";
		} else {
			dinnerService.updateDinner(id, dinner.getDinnerName(), dinner.getDinnerHours(), dinner.getDinnerLink());
			return "redirect:/dinners";
		}
	}
	
	@GetMapping("/decision")
	public String random(Model model) {
		Dinner dinner = this.dinnerService.getRandomDinner();
		model.addAttribute("dinner", dinner);
		return "decision.jsp";
	}
	
	@GetMapping("/decision/choose/{id}")
	public String Choose(@PathVariable("id") Long id, HttpSession session) {
		Long userId=(Long)session.getAttribute("userId");
		User user=userService.findUserById(userId);
		Dinner dinner=dinnerService.getOneDinner(id);
		System.out.println("HERE");
		System.out.println(userId);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(dinner.getId());
		System.out.println(dinner.getDinnerName());
		System.out.println(dinner.getDinnerHours());
		System.out.println(dinner.getDinnerLink());
		System.out.println(dinner.getUser());
		System.out.println(dinner.getUser().getName());
		
		dinnerService.chooseDinner(dinner, user);
		
		return "redirect:/ask";
	}
	
	@GetMapping("/dinners/unChoose/{dinnerId}")
	public String unChoose(@PathVariable("dinnerId") Long dinnerId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		Dinner dinner = dinnerService.getOneDinner(dinnerId);
		dinnerService.unChooseDinner(dinner, user);
		return "redirect:/dinners";
	}
}

