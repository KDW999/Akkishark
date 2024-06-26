package org.example.back.Board.service;

import java.util.List;

import org.example.back.Board.dto.request.PostBoardRequestDto;
import org.example.back.Board.dto.response.GetAllBoardResponseDto;
import org.example.back.Board.entity.BoardEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface BoardService {
	List<GetAllBoardResponseDto> getAllBoard();

	BoardEntity getBoard(int boardIdx);

	void deleteBoard(int boardIdx, UserDetails userDetails) throws Exception;

	void postBoard(PostBoardRequestDto boardDto, UserDetails userDetails);

	List<BoardEntity> getUserBoard(String nickname);
	void updateBoard(int boardIdx, PostBoardRequestDto boardDto, UserDetails userDetails);

	void countUp(int boardIdx);
}
