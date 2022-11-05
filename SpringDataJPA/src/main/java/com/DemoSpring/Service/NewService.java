package com.DemoSpring.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.DemoSpring.DTO.NewDTO;

public interface NewService {
	NewDTO save(NewDTO newDTO);
	
	List<NewDTO> getall();
	
	NewDTO get(Long id);
	
	void delete(Long id);
	
	List<NewDTO> Getbycontet(String content);

	List<NewDTO> GetSearch(String string);
	
	List<NewDTO> GetCategory(Long id);

	List<String> listCatogery();
	
	List<NewDTO> GetContentandThumbnail(String content,String thumbnail);
	//////////// Paging         ///////////////
	
	List<NewDTO> getall(Pageable pageable);
	
	int totalItem();
}
