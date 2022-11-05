package com.DemoSpring.DTO;

import java.util.ArrayList;
import java.util.List;

import com.DemoSpring.Entity.RoleEntity;
import com.DemoSpring.Entity.UserEntity;

public class RoleDTO {
	private Long id;
	private String name;
	private List<UserDTO> users = new ArrayList<UserDTO>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	public RoleDTO() {
		super();
	}
	public RoleDTO(RoleEntity entity) {

		this.id = entity.getId();
		this.name = entity.getName();
		for(UserEntity userEntity : entity.getUsers()) {
			UserDTO dto = new UserDTO();
			dto.setId(userEntity.getId());
			dto.setFullname(userEntity.getFullname());
			users.add(dto);
		}
	}
	
}
