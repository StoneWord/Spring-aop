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
	//�����е���ʽ
	
	@Pointcut("execution(* com.ssm.service.ProductService.*(..))")
	//ʹ��һ������ֵΪvoid��������Ϊ�յķ��������������
	private void allMethod() {
	}
	
	//ǰ��֪ͨ
//	@Before("allMethod()")
//	public void myBeforeAdvice(JoinPoint joinPoint) {
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		String logInfoText = "ǰ��֪ͨ��"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
//				+"  "+args.get(0).toString()+"�����Ʒ"+args.get(1).toString();
//		System.out.println(logInfoText);
//	}

	//����֪ͨ
//	@AfterReturning("allMethod()")
//	public void myAfterReturnAdvice(JoinPoint joinPoint) {
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		String logInfoText = "����֪ͨ��"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
//				+"  "+args.get(0).toString()+"�����Ʒ"+args.get(1).toString();
//		System.out.println(logInfoText);
//	}

	//�쳣֪ͨ
//	@AfterThrowing(pointcut="allMethod()",throwing="e")
//	public void myThrowingAdvice(JoinPoint joinPoint) {
//		//��ȡ�����õ�����
//		String targetClassName = joinPoint.getTarget().getClass().getName();
//		//��ȡ�����õķ�����
//		String targetMethodName = joinPoint.getSignature().getName();
//		//��־��ʽ�ַ���
//		String logInfoText = "�쳣֪ͨ��ִ��"+targetClassName+"���"+targetMethodName+"����ʱ�����쳣";
//		
//		System.out.println(logInfoText);
//	}
	
	
	//����֪ͨ
	  @Around("allMethod()") 
	  public void myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
			long beginTime = System.currentTimeMillis();
			joinPoint.proceed();
			long endTime = System.currentTimeMillis();
			long num = endTime-beginTime;
			//��ȡ�����õķ�����
			String targetMethoName = joinPoint.getSignature().getName();
			//��־��ʽ�ַ���
			String logInfoText ="����֪ͨ��"+targetMethoName+"��������ǰʱ�䣺"+beginTime+"����"
					+"  "+"�������ú�ʱ�䣺"+endTime+"����"+"   "+"��ʱ"+num+"����";
			System.out.println(logInfoText);
			
		}
	  
}
