package com.qetch.springmvc.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qetch.springmvc.domain.Product;
import com.qetch.springmvc.validator.ProductValidator;

@Controller
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value = "/product_input")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm";
	}
	
	@RequestMapping(value = "/product_save")
	public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult, Model model) {
		logger.info("--->saveProduct--->");
		Locale locale = Locale.getDefault();
		logger.info("--->locale: " + locale);
		ProductValidator productValidator = new ProductValidator();
		productValidator.validate(product, bindingResult);
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
			return "ProductForm";
		}
		// save product here
		model.addAttribute("product", product);
		return "ProductDetail";
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info("--->initBinder--->");
		// this will apply the validator to all request-handling methods
		binder.setValidator(new ProductValidator());
		binder.validate();
	}
	
	@RequestMapping(value = "/product_save2")
	public String saveProduct2(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
		logger.info("--->saveProduct2--->");
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
			return "ProductForm";
		}
		// save product here
		model.addAttribute("product", product);
		return "ProductDetail";
	}*/
}
