package com.gzm.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gzm.bbs.dto.BoardVO;
import com.gzm.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardMapper mapper;
	

	@Override
	public List<BoardVO> selectAll() {
		System.out.println( mapper.getList());
		return mapper.getList();
	}

	@Override
	public void insert(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO selectOne(int bno) {
		return mapper.read(bno);
	}

	@Override
	public void update(BoardVO board) {
		mapper.update(board);

	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);

	}


	public static void main(String[] args) {

	}

}
