package com.xp_spring_aop.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXML {
	//前置通知
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("权限校验----------"+joinPoint);
	}
	
	//后置通知
	public void writeLog(Object result) {
		System.out.println("日志记录-----------"+result);
	}
	
	//性能监控
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕通知1----------");
		Object object = joinPoint.proceed();//执行目标方法
		System.out.println("环绕通知2----------");
		return object;
	}
	//异常抛出通知
	public void afterThrowing(Throwable ex) {
		System.out.println("异常抛出通知"+ex.getMessage());
	}
	
	//最终通知
		public void after() {
			System.out.println("最终通知");
		}
}
