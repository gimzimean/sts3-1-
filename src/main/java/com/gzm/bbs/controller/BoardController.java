package com.gzm.bbs.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzm.bbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("controller 탔음 ");
		//view에 전달할 내용이 있을때  Model
		model.addAttribute("list",service.selectAll());
		System.out.println(model);
		System.out.println();
		return "list";
		
	}

}
