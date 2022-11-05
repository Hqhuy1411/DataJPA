package com.DemoSpring.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DemoSpring.Converter.NewConverter;
import com.DemoSpring.DTO.NewDTO;
import com.DemoSpring.Entity.CategoryEntity;
import com.DemoSpring.Entity.NewEntity;
import com.DemoSpring.Respository.CategoryRepository;
import com.DemoSpring.Respository.NewRepository;
import com.DemoSpring.Service.NewService;

@Service
public class NewServiceImpl implements NewService {
	@Autowired
	NewRepository newRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		if (listCatogery().contains(newDTO.getCategorycode())) {
			NewEntity newEntity = new NewEntity();
			CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategorycode());
			if (newDTO.getId() != null) {
				NewEntity oledNewEntity = newRepository.findById(newDTO.getId()).get();
				newEntity = newConverter.toEntity(newDTO, oledNewEntity);
			} else {
				newEntity = newConverter.toEntity(newDTO);
			}
			newEntity.setCategory(categoryEntity);
			newRepository.save(newEntity);
			return newConverter.toDTO(newEntity);
		} else {
			throw new ArithmeticException("Not esxits code of Category from your text");
			// return null;
		}
	}

	@Override
	public List<NewDTO> getall() {
		// TODO Auto-generated method stub
		List<NewEntity> list = newRepository.findAll();
		// List<NewEntity> list=newRepository.findCharacter();
		return newConverter.toListDTO(list);
	}

	@Override
	public void delete(Long id) {
		newRepository.deleteById(id);

	}

	@Override
	public NewDTO get(Long id) {
		NewEntity newEntity = newRepository.findById(id).get();
		return newConverter.toDTO(newEntity);

	}

	@Override
	public List<NewDTO> Getbycontet(String content) {
		List<NewEntity> listNewEntities = newRepository.findByContent(content);
		return newConverter.toListDTO(listNewEntities);
	}

	@Override
	public List<NewDTO> GetContentandThumbnail(String content, String thumbnail) {
		// TODO Auto-generated method stub
		List<NewEntity> listnewEntities = newRepository.findByContentandByThumbnail(content, thumbnail);
		return newConverter.toListDTO(listnewEntities);
	}

	@Override
	public List<NewDTO> GetSearch(String string) {
		List<NewEntity> listNewEntities = newRepository.findCharacter(string);
		return newConverter.toListDTO(listNewEntities);
	}

	// Get List Category.
	@Override
	public List<String> listCatogery() {
		List<String> list = new ArrayList<String>();
		list = categoryRepository.Listcode();
		return list;
	}

	@Override
	public List<NewDTO> getall(Pageable pageable) {
		// TODO Auto-generated method stub
		List<NewEntity> listNewEntities = newRepository.findAll(pageable).getContent();		
		return newConverter.toListDTO(listNewEntities);
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> GetCategory(Long id) {
		List<NewEntity> list = newRepository.findAllByCategory(id);
		
		return newConverter.toListDTO(list);
	}
}
