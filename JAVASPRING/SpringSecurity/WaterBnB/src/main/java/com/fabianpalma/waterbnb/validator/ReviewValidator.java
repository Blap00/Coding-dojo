package com.fabianpalma.waterbnb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fabianpalma.waterbnb.models.Review;
import com.fabianpalma.waterbnb.services.ReviewService;

@Component
public class ReviewValidator implements Validator {
	
	private ReviewService reviewService;
	
	public ReviewValidator(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Review.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		Review review = (Review) object;
	}
}
