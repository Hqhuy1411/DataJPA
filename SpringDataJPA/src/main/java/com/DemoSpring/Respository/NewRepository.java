package com.DemoSpring.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DemoSpring.Entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	@Query("FROM NewEntity WHERE category_id = ?1")
	List<NewEntity> findAllByCategory(Long id);

	@Query("FROM NewEntity WHERE content = ?1 ")
	List<NewEntity> findByContent(String content);
	
	@Query("SELECT a FROM NewEntity a Where a.content =?1 AND a.thumbnail=?2")
	List<NewEntity> findByContentandByThumbnail(String content,String thumbnail);
	//Defaul
	@Query("SELECT a FROM NewEntity a Where a.content like '%ba%' ")
	List<NewEntity> findCharacter();
	//string
	@Query("SELECT a FROM NewEntity a Where a.content like %:name% ")
	List<NewEntity> findCharacter(@Param("name")String charaters);
}
