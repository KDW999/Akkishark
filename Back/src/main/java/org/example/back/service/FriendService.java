package org.example.back.service;

import java.util.List;

import org.example.back.dto.response.FriendDetailResponseDto;
import org.example.back.dto.response.FriendResponseDto;

public interface FriendService {
	List<FriendResponseDto> findAllFriend(int userIdx);
	FriendDetailResponseDto findFriendDetail(int userIdx);
}
