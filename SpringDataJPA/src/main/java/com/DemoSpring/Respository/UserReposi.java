package com.DemoSpring.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DemoSpring.Entity.UserEntity;

public interface UserReposi extends JpaRepository<UserEntity, Long>{

}
