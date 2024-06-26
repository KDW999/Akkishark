package org.example.back.Friend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.example.back.Friend.dto.response.FriendDetailResponseDto;
import org.example.back.Friend.dto.response.FriendResponseDto;
import org.example.back.Friend.entity.FriendEntity;
import org.example.back.User.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {
	@Query(
		value = "SELECT new org.example.back.Friend.dto.response.FriendResponseDto(u.userIdx, u.nickname, u.profileImage) "
			+ "FROM User u "
			+ "WHERE u.userIdx IN ("
			+ "    SELECT f.fromUserIdx "
			+ "    FROM FRIEND f "
			+ "    WHERE f.fromUserIdx IN ("
			+ "        SELECT f.toUserIdx "
			+ "        FROM FRIEND f "
			+ "        WHERE f.fromUserIdx = :userIdx AND f.areFriend = 1"
			+ "    ) AND f.toUserIdx = :userIdx AND f.areFriend = 1"
			+ ")"
	)
	List<FriendResponseDto> findAllFriend(@Param("userIdx") int userIdx);

	@Query(
		value = "SELECT new org.example.back.Friend.dto.response.FriendDetailResponseDto(u.userIdx, u.nickname, u.userEmail, u.profileImage, t.userTier, t.clearCnt) "
			+ "FROM User u "
			+ "JOIN Tier t "
			+ "ON u.userIdx = t.userIdx "
			+ "WHERE u.userIdx = :userIdx"
	)
	FriendDetailResponseDto findFriendDetail(int userIdx);

	@Query("SELECT u FROM User u WHERE u.userEmail LIKE %:userEmail%")
	List<UserEntity> findByUserEmail(@Param("userEmail") String userEmail);

	@Query("SELECT u FROM User u WHERE u.nickname LIKE %:userNickname%")
	List<UserEntity> findByUserNickname(@Param("userNickname") String userNickname);

	@Modifying
	@Transactional
	@Query("UPDATE FRIEND SET areFriend = 1 WHERE fromUserIdx = :requestUserIdx AND toUserIdx = :responseUserIdx")
	void acceptRequest(@Param("requestUserIdx") int requestUserIdx, @Param("responseUserIdx")int responseUserIdx);
}
