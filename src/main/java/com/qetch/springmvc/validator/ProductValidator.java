package com.qetch.springmvc.validator;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qetch.springmvc.domain.Product;

public class ProductValidator implements Validator {
	private static final Log logger = LogFactory.getLog(ProductValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate", "productiondate.required");
		Float price = product.getPrice();
		if (price != null && price < 0) {
			errors.rejectValue("price", "price.negative");
		}
		Date productionDate = product.getProductionDate();
		if (productionDate != null) {
			// The hour,minute,second components of productionDate are 0
			if (productionDate.after(new Date())) {
				logger.info("salah lagi");
				errors.rejectValue("productionDate", "productiondate.invalid");
			}
		}
	}

}
