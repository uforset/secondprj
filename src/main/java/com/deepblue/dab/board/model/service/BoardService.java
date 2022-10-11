package com.deepblue.dab.board.model.service;

import java.util.ArrayList;

import com.deepblue.dab.board.vo.Board;
import com.deepblue.dab.common.Paging;
import com.deepblue.dab.common.SearchDate;
import com.deepblue.dab.common.SearchPaging;

public interface BoardService {
	ArrayList<Board> selectTop3();
	int selectListCount();  //총 게시글 갯수 조회용(페이지 수 계산용)
	ArrayList<Board> selectList(Paging page);  //한 페이지 출력할 게시글 조회용
	Board selectBoard(int board_num); //해당 번호에 대한 게시글 상세 조회용
	int updateAddReadcount(int board_num); //상세보기시에 조회수 1증가 처리용
	int insertOriginBoard(Board board); //원글 등록용
	int insertReply(Board reply); //댓글 등록용 (대댓글 등록 포함)
	int updateReplySeq(Board reply); //댓글 등록시 기존 댓글 순번을 1증가 처리(최신글이 1이 되게 함)
	int updateOrigin(Board board);  //원글 수정용
	int updateReply(Board reply);  //댓글 수정용
	int deleteBoard(Board board);  //게시글 삭제용
	ArrayList<Board> selectSearchTitle(SearchPaging searchpaging);
	ArrayList<Board> selectSearchWriter(SearchPaging searchpaging);
	ArrayList<Board> selectSearchDate(SearchPaging searchpaging);
	int selectSearchWListCount(String keyword);
	int selectSearchTListCount(String keyword);
	int selectSearchDListCount(SearchDate date);
	
	
}
