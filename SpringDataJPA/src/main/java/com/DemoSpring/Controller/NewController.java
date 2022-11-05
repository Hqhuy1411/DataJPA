package com.DemoSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DemoSpring.Controller.NewPage.NewOutput;
import com.DemoSpring.DTO.NewDTO;
import com.DemoSpring.Entity.CategoryEntity;
import com.DemoSpring.Respository.CategoryRepository;
import com.DemoSpring.Service.NewService;

@RestController
public class NewController {
	@Autowired
	NewService newService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/news")
	public List<NewDTO> listnewDtos() {
		return newService.getall();
	}

	@GetMapping("/listnews")
	public NewOutput listpage(@RequestParam(value="page",defaultValue = "1") int page,
								 @RequestParam(value="limit",defaultValue = "1") int limit) {
		NewOutput result = new NewOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page-1,limit);
		result.setList(newService.getall(pageable));
		result.setTotalPage((int) Math.ceil((double) (newService.totalItem())/limit));
		
		return result;
	}

	
	@GetMapping("/new/{id}")
	public NewDTO get(@PathVariable("id") Long id) {
		NewDTO newDTO = new NewDTO();
		newDTO = newService.get(id);

		return newDTO;
	}

	@GetMapping("/news/content={content}")
	public List<NewDTO> listbyContent(@PathVariable("content") String content) {
		return newService.Getbycontet(content);
	}
	// giống nhau -> localhost:8080/list?content='bon'
//	@GetMapping("/list")
//	public List<NewDTO> list(@RequestParam(value="content",defaultValue = "bon")String name) {
//		return newService.Getbycontet(name);
//	}

	@GetMapping("/news/{content}/{thumbnail}")
	public List<NewDTO> listbyContentandbyThumbnail(@PathVariable("content") String content
													,@PathVariable("thumbnail") String thumbnail){
		System.out.println(content);
		System.out.println(thumbnail);
		return newService.GetContentandThumbnail(content,thumbnail);
	}
/* localhost:8080/list?content='aba'&thumbnail='aba'	
	@GetMapping("/list")
	public List<NewDTO> list(@RequestParam(value="content")String name1
			,@RequestParam(value="thumbnail")String name2) {
		System.out.println(name1);
		System.out.println(name2);
		return newService.GetContentandThumbnail(name1,name2);
	} */
	
	// LIKE SQL.
	@GetMapping("/news/search={string}")
	public List<NewDTO> listSearch(@PathVariable("string") String string) {
		System.out.println(string);
		return newService.GetSearch(string);
	}
	@GetMapping("/the-loai")
	public List<NewDTO> theloai(@RequestParam(value="category",defaultValue = "the-thao")String name){
		List<String> listcategory = newService.listCatogery();
		if(listcategory.contains(name)==false) {
			return null;
		}else {
			CategoryEntity categoryEntity = categoryRepository.findOneByCode(name);
			
			return newService.GetCategory(categoryEntity.getId());
		}
	}
	
	
	
	// THEM
	@PostMapping("/new")
	public NewDTO createNewDTO(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	// CAP NHAT
	@PutMapping("/new/{id}")
	public NewDTO update(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		if(newService.save(model) == null) {
			System.out.println("Loi");
		}
		return newService.save(model);
	}
	// XOA
	@DeleteMapping("/new/{id}")
	public String delete(@PathVariable("id") Long id) {
		newService.delete(id);
		return "New has deleted with id :" + id;
	}
}
