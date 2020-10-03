package com.ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.service.ProductService;

public class TestAop {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productService");
		productService.browse("’≈»˝", "Lenovo ÃÏ“›310");
	}

}
