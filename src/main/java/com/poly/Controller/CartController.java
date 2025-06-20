package com.poly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

	@GetMapping
	public String index() {
		return ("cart/index");
	}

	@GetMapping("/info")
	public String info() {
		return ("cart/info");
	}

	@GetMapping("/checkout")
	public String checkout() {
		return ("cart/checkout");
	}

	@GetMapping("/result")
	public String result() {
		return ("cart/result");
	}

}
