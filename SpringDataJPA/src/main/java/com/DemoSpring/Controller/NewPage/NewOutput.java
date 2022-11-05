package com.DemoSpring.Controller.NewPage;

import java.util.List;

import com.DemoSpring.DTO.NewDTO;

public class NewOutput {
	private int page;
	private int totalPage;
	private List<NewDTO> list;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<NewDTO> getList() {
		return list;
	}
	public void setList(List<NewDTO> list) {
		this.list = list;
	}
	
}
