package com.gzm.bbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gzm.bbs.dto.BoardVO;
import com.gzm.bbs.dto.Criteria;
import com.gzm.bbs.dto.PageMaker;
import com.gzm.bbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	BoardService service;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("controller 탔음 ");
		//view에 전달할 내용이 있을때  Model
		
		//페이징
		int totalCount=service.totalCount(cri);
		PageMaker pageMaker =new  PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker",pageMaker);
		
		
		
		model.addAttribute("list",service.selectAll(cri));
		System.out.println(model);
		System.out.println();
		return "list";
		
	}
	
	@RequestMapping("/input")
	public String input() {
		return "input";
		
	}
	
	@GetMapping("/input")
	public String insert() {
		return "input";//insert form 이할거고
	}
	@PostMapping("/input")
	public String insert(@ModelAttribute("board") BoardVO board) {//@ModelAttribute("board") 받아서 BoardVO
		service.insert(board);
		return "redirect:list";// insert 처리하는 곳
		
	}
	@GetMapping("/update")
	public String update( @RequestParam("bno") int bno, Model model) {//?bno=${bno}받는거임  requestparam
		model.addAttribute("board",service.selectOne(bno));
		return "update";
	}
	@PostMapping("/update")
	
	public String update(@ModelAttribute("board") BoardVO board) {
		service.update(board);
		return "redirect:list";
		

	}
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno) {
		service.delete(bno);
		return "redirect:list";
	}

}
