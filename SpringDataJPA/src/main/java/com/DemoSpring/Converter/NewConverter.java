package com.DemoSpring.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DemoSpring.DTO.NewDTO;
import com.DemoSpring.Entity.NewEntity;

@Component
public class NewConverter {
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity(); 
		newEntity.setContent(newDTO.getContent());
		newEntity.setThumbnail(newDTO.getThumbnail());
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setShortDescription(newDTO.getShortDescription());
		
		return newEntity;
		
	}
	public NewEntity toEntity(NewDTO newDTO, NewEntity oldnewEntity) {
		oldnewEntity.setContent(newDTO.getContent());
		oldnewEntity.setThumbnail(newDTO.getThumbnail());
		oldnewEntity.setTitle(newDTO.getTitle());
		oldnewEntity.setShortDescription(newDTO.getShortDescription());
		
		return oldnewEntity;
		
	}
	public NewDTO toDTO(NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		newDTO.setId(newEntity.getId());
		newDTO.setContent(newEntity.getContent());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setThumbnail(newEntity.getThumbnail());
		newDTO.setCategorycode(newEntity.getCategory().getCode());
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setCreateDate(newEntity.getCreateDate());
		return newDTO;
	}
	public List<NewDTO> toListDTO(List<NewEntity> list){
		List<NewDTO> listnewDtos = new ArrayList<NewDTO>();
		for(NewEntity newEntity : list) {
			listnewDtos.add(toDTO(newEntity));
		}
		return listnewDtos;
	}
}
