package com.DemoSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.DemoSpring.Entity.UserEntity;
import com.DemoSpring.Respository.RoleRepos;
import com.DemoSpring.Respository.UserReposi;

@Controller
public class UserController {

	@Autowired
	UserReposi userReposi;

	@Autowired
	RoleRepos roleRepos;

//	  @GetMapping("get/{id}")
//	  public UserDTO get(@PathVariable("id") Long id) {
//		  UserEntity entity =  userReposi.getById(id);
//		  UserDTO dto = new UserDTO(entity);
//		  return dto;
//	  }
	@GetMapping("get/{id}")
	public UserEntity get(@PathVariable("id") Long id) {
		return userReposi.findById(id).get();
	}

	@GetMapping("/page")
	public String getall(Model model) {
//		  List<UserEntity> list = userReposi.findAll();
//		  model.addAttribute("list", list);
		return "NewFile";
	}
}
