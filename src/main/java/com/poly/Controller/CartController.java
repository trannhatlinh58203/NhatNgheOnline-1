package com.poly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.Model.Cart;
import com.poly.Model.User;
import com.poly.Security.CustomUserDetails;
import com.poly.Service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	public String index(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		User currentUser = userDetails.getUser();

		List<Cart> cartItems = cartService.getCartItems(currentUser);
		double totalPrice = cartService.getTotalPrice(currentUser);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalPrice", totalPrice);
		return "cart/index";
	}

	@GetMapping("/info")
	public String info(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
		model.addAttribute("user", userDetails.getUser());
		double totalPrice = cartService.getTotalPrice(userDetails.getUser());
		model.addAttribute("totalPrice", totalPrice);
		return "cart/info";
	}

	@GetMapping("/checkout")
	public String checkout() {
		return ("cart/checkout");
	}

	@GetMapping("/result")
	public String result() {
		return ("cart/result");
	}

	@PostMapping("/update")
	public String updateQuantity(@RequestParam("productId") Integer productId,
			@RequestParam("quantity") Integer quantity, @AuthenticationPrincipal CustomUserDetails userDetails) {
		User user = userDetails.getUser();
		cartService.updateQuantity(user, productId, quantity);
		return "redirect:/cart";
	}

	@PostMapping("/remove")
	public String removeFromCart(@RequestParam("productId") Integer productId,
			@AuthenticationPrincipal CustomUserDetails userDetails) {
		User user = userDetails.getUser();
		System.out.println("Removing productId: " + productId + " for user: " + user.getUserID());
		cartService.removeFromCart(user, productId);
		return "redirect:/cart";
	}

}
