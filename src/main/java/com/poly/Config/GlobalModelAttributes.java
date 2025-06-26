package com.poly.Config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.poly.Security.CustomUserDetails;

//tạo các biến global để dùng ở mọi file

@ControllerAdvice
public class GlobalModelAttributes {

	// truyền current user đến mọi model
	@ModelAttribute
	public void addCurrentUser(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof CustomUserDetails) {
			CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
			model.addAttribute("currentUser", userDetails.getUser());
		}
	}
}
