package com.poly.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.Model.Product;

@Controller
public class AppController {

	@GetMapping("/")
	public String home(Model model) {
		List<Product> bestSellerPCs = List.of(
				new Product(null, "PC GVN i5-12400F/ RTX 3050", "Mô tả", 13390000, "/images/products/1.png", 5, null,
						null),
				new Product(null, "PC GODLIKE 285K", "Mô tả", 178990000, "/images/products/1.png", 8, null, null),
				new Product(null, "PC GVN i5-12400F/ RTX 7600", "Mô tả", 16990000, "/images/products/1.png", 3, null,
						null),
				new Product(null, "PC Core Ultra 7 RTX 5080", "Mô tả", 71990000, "/images/products/1.png", 2, null,
						null),
				new Product(null, "PC Intel i9-14900K/ RTX 5090", "Mô tả", 169990000, "/images/products/1.png", 1, null,
						null),
				new Product(null, "PC GVN Ryzen 7/ RTX 4060", "Mô tả", 19990000, "/images/products/1.png", 9, null,
						null),
				new Product(null, "PC GVN Intel i5/ GTX 1650", "Mô tả", 11390000, "/images/products/1.png", 6, null,
						null),
				new Product(null, "PC GVN Ryzen 9/ RTX 4080", "Mô tả", 88990000, "/images/products/1.png", 4, null,
						null));

		List<Product> bestSellerLaptops = List.of(
				new Product(null, "Laptop Gaming MSI GF63", "Mô tả", 18990000, "/images/products/1.png", 5, null, null),
				new Product(null, "Laptop ASUS ROG Strix G15", "Mô tả", 24990000, "/images/products/1.png", 6, null,
						null),
				new Product(null, "Laptop Acer Nitro 5", "Mô tả", 20990000, "/images/products/1.png", 3, null, null),
				new Product(null, "Laptop HP Victus", "Mô tả", 18900000, "/images/products/1.png", 4, null, null),
				new Product(null, "Laptop Lenovo Legion 5", "Mô tả", 27990000, "/images/products/1.png", 2, null, null),
				new Product(null, "Laptop Gigabyte G5", "Mô tả", 19500000, "/images/products/1.png", 1, null, null),
				new Product(null, "Laptop ASUS TUF F15", "Mô tả", 22500000, "/images/products/1.png", 7, null, null),
				new Product(null, "Laptop Dell Gaming G15", "Mô tả", 23990000, "/images/products/1.png", 5, null,
						null));

		List<Product> bestSellerKeyboards = List.of(
				new Product(null, "Bàn phím cơ Akko 3087", "Mô tả", 990000, "/images/products/1.png", 12, null, null),
				new Product(null, "Bàn phím DareU EK87", "Mô tả", 790000, "/images/products/1.png", 10, null, null),
				new Product(null, "Bàn phím Logitech G213", "Mô tả", 1290000, "/images/products/1.png", 8, null, null),
				new Product(null, "Bàn phím Razer Cynosa", "Mô tả", 1150000, "/images/products/1.png", 6, null, null),
				new Product(null, "Bàn phím Corsair K55", "Mô tả", 1350000, "/images/products/1.png", 4, null, null),
				new Product(null, "Bàn phím Fuhlen L87S", "Mô tả", 690000, "/images/products/1.png", 5, null, null),
				new Product(null, "Bàn phím HyperX Alloy", "Mô tả", 1590000, "/images/products/1.png", 3, null, null),
				new Product(null, "Bàn phím Motospeed CK62", "Mô tả", 850000, "/images/products/1.png", 2, null, null));

		List<Product> cheapMonitors = List.of(
				new Product(null, "Màn hình ViewSonic 24\"", "Mô tả", 2990000, "/images/products/1.png", 9, null, null),
				new Product(null, "Màn hình LG 24MK600", "Mô tả", 3190000, "/images/products/1.png", 7, null, null),
				new Product(null, "Màn hình Samsung LF24", "Mô tả", 2890000, "/images/products/1.png", 6, null, null),
				new Product(null, "Màn hình ASUS VA24E", "Mô tả", 3090000, "/images/products/1.png", 5, null, null),
				new Product(null, "Màn hình AOC 24B1", "Mô tả", 2790000, "/images/products/1.png", 3, null, null),
				new Product(null, "Màn hình HP 24mh", "Mô tả", 2690000, "/images/products/1.png", 4, null, null),
				new Product(null, "Màn hình Xiaomi 1C", "Mô tả", 2490000, "/images/products/1.png", 2, null, null),
				new Product(null, "Màn hình Dell SE2419HX", "Mô tả", 3190000, "/images/products/1.png", 1, null, null));

		// Truyền vào view
		model.addAttribute("bestSellerPCs", bestSellerPCs);
		model.addAttribute("bestSellerLaptops", bestSellerLaptops);
		model.addAttribute("bestSellerKeyboards", bestSellerKeyboards);
		model.addAttribute("cheapMonitors", cheapMonitors);

		return "home/index";
	}

	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return ("product/search");
	}
}
