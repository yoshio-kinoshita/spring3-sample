package com.github.yoshio.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.github.yoshio.service.Product;

@Aspect
@Component
public class SampleAspect {

	@Before("execution(* findProduct(String))")
	public void before() {
		System.out.println("hello before!");
	}

	@After("execution(* findProduct(String))")
	public void after() {
		System.out.println("hello after!");
	}

	@AfterReturning(value = "execution(* findProduct(String))", returning = "product")
	public void afterReturning(Product product) {
		System.out.println("hello afterReturning!*** product.name:"
				+ product.getName());
	}

	@Around("execution(* findProduct(String))")
	public Product around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("hello around! before:");
		Product product = (Product) pjp.proceed();
		System.out.println("hello around! after!*** product.name:"
				+ product.getName());

		return product;
	}

	@AfterThrowing(value = "execution(* findProduct(String))", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("hello throwable!");
	}

}
