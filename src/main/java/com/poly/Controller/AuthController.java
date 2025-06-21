
package com.poly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/logout")
	public String index() {
		return "redirect:/";
	}
}
