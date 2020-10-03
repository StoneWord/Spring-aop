package com.ssm.service.impl;

import org.springframework.stereotype.Component;

import com.ssm.service.ProductService;

@Component("productService")
public class ProductServiceImpl implements ProductService {

	@Override
	/*public void browse(String loginName, String ProductName) {
		System.out.println("执行业务方法browse");
		throw new RuntimeException("这是特意抛出的异常信息！"); 
	}*/
	
	public void browse(String loginName, String ProductName) {
		System.out.println("执行业务方法browse");
		int i = 1000000;
		while(i>0) {
			i--;
		}
	}

}
