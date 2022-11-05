package com.DemoSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DemoSpring.Entity.RoleEntity;
import com.DemoSpring.Respository.RoleRepos;

@RestController
public class RoleController {
	@Autowired
	RoleRepos roleRepos;
	
//	@GetMapping("role/get/{id}")
//	public RoleDTO get(@PathVariable("id") Long id) {
//		
//		RoleEntity roleEntity = roleRepos.getById(id);
//		RoleDTO dto = new RoleDTO(roleEntity);
//		return dto;
//		
//	}
//	
	@GetMapping("role/get/{id}")
	public RoleEntity get(@PathVariable("id") Long id) {
		
		return roleRepos.findById(id).get();
		
	}
}
