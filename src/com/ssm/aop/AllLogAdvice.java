package com.ssm.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class AllLogAdvice {
	//定义切点表达式
	
	@Pointcut("execution(* com.ssm.service.ProductService.*(..))")
	//使用一个返回值为void，方法体为空的方法来命名切入点
	private void allMethod() {
	}
	
	//前置通知
//	@Before("allMethod()")
//	public void myBeforeAdvice(JoinPoint joinPoint) {
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		String logInfoText = "前置通知："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
//				+"  "+args.get(0).toString()+"浏览商品"+args.get(1).toString();
//		System.out.println(logInfoText);
//	}

	//返回通知
//	@AfterReturning("allMethod()")
//	public void myAfterReturnAdvice(JoinPoint joinPoint) {
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		String logInfoText = "返回通知："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
//				+"  "+args.get(0).toString()+"浏览商品"+args.get(1).toString();
//		System.out.println(logInfoText);
//	}

	//异常通知
//	@AfterThrowing(pointcut="allMethod()",throwing="e")
//	public void myThrowingAdvice(JoinPoint joinPoint) {
//		//获取被调用的类名
//		String targetClassName = joinPoint.getTarget().getClass().getName();
//		//获取被调用的方法名
//		String targetMethodName = joinPoint.getSignature().getName();
//		//日志格式字符串
//		String logInfoText = "异常通知：执行"+targetClassName+"类的"+targetMethodName+"方法时发生异常";
//		
//		System.out.println(logInfoText);
//	}
	
	
	//环绕通知
	  @Around("allMethod()") 
	  public void myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
			long beginTime = System.currentTimeMillis();
			joinPoint.proceed();
			long endTime = System.currentTimeMillis();
			long num = endTime-beginTime;
			//获取被调用的方法名
			String targetMethoName = joinPoint.getSignature().getName();
			//日志格式字符串
			String logInfoText ="环绕通知："+targetMethoName+"方法调用前时间："+beginTime+"毫秒"
					+"  "+"方法调用后时间："+endTime+"毫秒"+"   "+"耗时"+num+"毫秒";
			System.out.println(logInfoText);
			
		}
	  
}
