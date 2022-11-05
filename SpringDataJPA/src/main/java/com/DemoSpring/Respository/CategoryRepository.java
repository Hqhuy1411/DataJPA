package com.DemoSpring.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DemoSpring.Entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
	CategoryEntity findOneByCode(String code);
	
	@Query("SELECT a.code FROM CategoryEntity a ")
	List<String> Listcode();
}
