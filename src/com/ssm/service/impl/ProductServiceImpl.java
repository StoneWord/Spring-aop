package com.ssm.service.impl;

import org.springframework.stereotype.Component;

import com.ssm.service.ProductService;

@Component("productService")
public class ProductServiceImpl implements ProductService {

	@Override
	/*public void browse(String loginName, String ProductName) {
		System.out.println("ִ��ҵ�񷽷�browse");
		throw new RuntimeException("���������׳����쳣��Ϣ��"); 
	}*/
	
	public void browse(String loginName, String ProductName) {
		System.out.println("ִ��ҵ�񷽷�browse");
		int i = 1000000;
		while(i>0) {
			i--;
		}
	}

}
