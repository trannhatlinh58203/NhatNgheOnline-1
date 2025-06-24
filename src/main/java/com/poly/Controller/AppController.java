package com.poly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.Model.Product;
import com.poly.Repository.ProductRepository;

@Controller
public class AppController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String home(Model model) {
		// Lấy 8 sản phẩm ngẫu nhiên theo danh mục
		List<Product> bestSellerPCs = productRepository.findTop8ByCategoryNameRandom("PC");
		List<Product> bestSellerLaptops = productRepository.findTop8ByCategoryNameRandom("Laptop");
		List<Product> bestSellerKeyboards = productRepository.findTop8ByCategoryNameRandom("Bàn phím");
		List<Product> cheapMonitors = productRepository.findTop8ByCategoryNameRandom("Màn hình");

		model.addAttribute("bestSellerPCs", bestSellerPCs);
		model.addAttribute("bestSellerLaptops", bestSellerLaptops);
		model.addAttribute("bestSellerKeyboards", bestSellerKeyboards);
		model.addAttribute("cheapMonitors", cheapMonitors);

		return "home/index";
	}

	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, @RequestParam(required = false) String brand,
			@RequestParam(required = false) String sort, Model model) {

		List<Product> results;

		// Lọc + sắp xếp
		if (brand != null && !brand.isEmpty()) {
			if ("asc".equals(sort)) {
				results = productRepository.findByProductNameContainingIgnoreCaseAndBrandNameOrderByPriceAsc(keyword,
						brand);
			} else if ("desc".equals(sort)) {
				results = productRepository.findByProductNameContainingIgnoreCaseAndBrandNameOrderByPriceDesc(keyword,
						brand);
			} else {
				results = productRepository.findByProductNameContainingIgnoreCaseAndBrandName(keyword, brand);
			}
		} else {
			if ("asc".equals(sort)) {
				results = productRepository.findByProductNameContainingIgnoreCaseOrderByPriceAsc(keyword);
			} else if ("desc".equals(sort)) {
				results = productRepository.findByProductNameContainingIgnoreCaseOrderByPriceDesc(keyword);
			} else {
				results = productRepository.findByProductNameContainingIgnoreCase(keyword);
			}
		}

		List<String> brands = productRepository.findDistinctBrandNamesByKeyword(keyword);

		model.addAttribute("keyword", keyword);
		model.addAttribute("products", results);
		model.addAttribute("brands", brands);
		model.addAttribute("selectedBrand", brand);
		model.addAttribute("selectedSort", sort);

		return "product/search";
	}

}
