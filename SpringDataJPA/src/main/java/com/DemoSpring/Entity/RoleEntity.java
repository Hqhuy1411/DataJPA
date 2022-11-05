package com.DemoSpring.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "role")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RoleEntity extends BaseEntity {
	@Column
	private String code;
	@Column
	private String name;

	@ManyToMany(mappedBy = "roles")
//	@JsonBackReference
	// user JsonBackReference and JsonManegedReference thì bất tiện tại vì phải
	// chuyển đổi khi sử dụng
	private List<UserEntity> users = new ArrayList<UserEntity>();

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
