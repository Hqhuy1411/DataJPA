package com.DemoSpring.DTO;

import java.util.ArrayList;
import java.util.List;

import com.DemoSpring.Entity.RoleEntity;
import com.DemoSpring.Entity.UserEntity;

public class UserDTO {
	private Long id;
	private String fullname;
	private List<RoleDTO> roles = new ArrayList<RoleDTO>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public List<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	public UserDTO() {
	}
	public UserDTO(UserEntity entity) {

		this.id = entity.getId();
		this.fullname = entity.getFullname();
		for(RoleEntity roleEntity : entity.getRoles()) {
			RoleDTO dto = new RoleDTO();
			dto.setId(roleEntity.getId());
			dto.setName(roleEntity.getName());
			roles.add(dto);
		}
	}
	
}
