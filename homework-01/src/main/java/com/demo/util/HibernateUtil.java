package com.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 单例模式
 * 
 * @author Administrator
 *
 */
public class HibernateUtil {
	// 1.声明需要初始化的private单例属性（静态常量static final）
	private static final SessionFactory sessionFactory = buildSessionFactory();

	// 2.声明private的初始化单例的方法
	private static SessionFactory buildSessionFactory() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return null;
	}

	// 3.提供公共外部获取单例方法
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}