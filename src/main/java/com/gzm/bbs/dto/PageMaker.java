package com.gzm.bbs.dto;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum=10;
	
	private Criteria cri;
	

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcDate();//페이징 계산하는 메서드
	}
	private void calcDate() {
		endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage=(endPage-displayPageNum)+1;

		//마지막 페이지 보정
		int tendpage=(int)(Math.ceil(totalCount)/(double)cri.getPerPageNum());
		if (endPage>tendpage) 
			endPage=tendpage;
			prev=startPage==1?false:true;
			//next=endPage*cri.getPerPageNum()>=totalCount?false:true;//endPage*cri.getPerPageNum() record 갯수
			next=endPage>=tendpage?false:true;
			
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	
	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
}
