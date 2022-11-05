package com.DemoSpring.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DemoSpring.Entity.RoleEntity;

public interface RoleRepos extends JpaRepository<RoleEntity, Long>{

}
