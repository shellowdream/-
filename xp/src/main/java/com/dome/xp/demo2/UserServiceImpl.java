package com.dome.xp.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("UserService")
@Scope("prototype")
public class UserServiceImpl implements UserService {

	//注入DAO
//	@Autowired
//	@Qualifier(value="userdao")
	@Resource(name="userdao")
	private Userdao userdao;

	public void save() {
		System.out.println("UserService  save……");
		userdao.save();
	}

}
