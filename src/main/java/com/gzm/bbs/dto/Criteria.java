package com.gzm.bbs.dto;

public class Criteria {
	private int page;//한 페이지 
	private int perPageNum;//한 페이지 당 
	
	public Criteria() {
		super();
		this.page = 1;
		this.perPageNum = 10;//default
	}

	public void setPage(int page) {
		if (page<=0) {
			this.page=1;
			return;//0 페이지, -1페이지 나오면 무조건 1페이지로 ㄱ ㄱ 
			
		}
		this.page=page;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum<=0 || perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	public int getPageStart() {
		return (this.perPageNum-1)*perPageNum;
		
		//필드 는 1번부터 시작
		//record는 0부터 시작
		//2번 20페이지가 첫 페이지가 되겠찌 
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}

	//Checking 하려고 
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
	
	
	

}
