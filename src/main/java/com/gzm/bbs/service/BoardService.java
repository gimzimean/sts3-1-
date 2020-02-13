package com.gzm.bbs.service;

import java.util.List;

import com.gzm.bbs.dto.BoardVO;

public interface BoardService {
	public List<BoardVO> selectAll();
	public void insert(BoardVO board);
	public BoardVO selectOne(int bno);
	public void update(BoardVO board);
	public void delete(int bno);

}
