package com.easy.validator.rules;

import com.easy.validator.annotations.InRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/29 14:39
 * @Version: 1.0
 */
public class InRangeValidator implements ConstraintValidator<InRange, Integer> {
    private int min;
    private int max;

    @Override
    public void initialize(InRange constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || (value >= min && value <= max);
    }
}
