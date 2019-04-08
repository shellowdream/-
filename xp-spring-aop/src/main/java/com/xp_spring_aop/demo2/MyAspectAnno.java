package com.xp_spring_aop.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspectAnno {
		//前置通知
		@Before(value="MyAspectAnno.pointcut1()")
		public void checkPri(JoinPoint joinPoint) {
			System.out.println("权限校验----------"+joinPoint);
		}
		
		//后置通知
		@AfterReturning(value="MyAspectAnno.pointcut4()",returning="result")
		public void writeLog(Object result) {
			System.out.println("日志记录-----------"+result);
		}
		
		//性能监控
		@Around(value="MyAspectAnno.pointcut2()")
		public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
			System.out.println("环绕通知1----------");
			Object object = joinPoint.proceed();//执行目标方法
			System.out.println("环绕通知2----------");
			return object;
		}
		//异常抛出通知
		@AfterThrowing(value="MyAspectAnno.pointcut3()",throwing="ex")
		public void afterThrowing(Throwable ex) {
			System.out.println("异常抛出通知"+ex.getMessage());
		}
		
		//最终通知
		@After(value="MyAspectAnno.pointcut3()")
			public void after() {
				System.out.println("最终通知");
			}
		// 切入点注解：
		@Pointcut(value="execution(* com.xp_spring_aop.demo2.OrderDao.save(..))")
		private void pointcut1(){}
		@Pointcut(value="execution(* com.xp_spring_aop.demo2.OrderDao.update(..))")
		private void pointcut2(){}
		@Pointcut(value="execution(* com.xp_spring_aop.demo2.OrderDao.find(..))")
		private void pointcut3(){}
		@Pointcut(value="execution(* com.xp_spring_aop.demo2.OrderDao.delete(..))")
		private void pointcut4(){}
}
