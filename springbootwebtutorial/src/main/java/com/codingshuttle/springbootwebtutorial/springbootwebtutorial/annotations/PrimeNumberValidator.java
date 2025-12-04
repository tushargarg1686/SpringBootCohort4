package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        // 0, 1, and negative numbers are not prime
        if (number <= 1) {
            return false;
        }
        // 2 is the only even prime number
        if (number == 2) {
            return true;
        }
        // If the number is even and greater than 2, it's not prime
        if (number % 2 == 0) {
            return false;
        }
        // Check for odd divisors from 3 up to the square root of the number
        // Increment by 2 to only check odd numbers
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        return true; // No divisors found, so it's prime
    }
}
