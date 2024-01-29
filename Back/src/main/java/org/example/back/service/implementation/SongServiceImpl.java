package org.example.back.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.example.back.common.ErrorCode;
import org.example.back.common.NotFoundException;
import org.example.back.dto.response.SongResponseDto;
import org.example.back.entity.SongEntity;
import org.example.back.repository.SongRepository;
import org.example.back.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

	private final SongRepository songRepository;

	//전체 음악 조회
	@Override
	public List<SongResponseDto> findAllSong() {
		List<SongEntity> allSong = songRepository.findAllSong();

		List<SongResponseDto> songLineDtos = new ArrayList<>();
		for (SongEntity song : allSong) {
			SongResponseDto songResponseDto = new SongResponseDto(
				song.getSongIdx(),
				song.getTitle(),
				song.getSinger()
			);
			songLineDtos.add(songResponseDto);
		}
		return songLineDtos;
	}

	//음악 선택 시 songLine 등 상세 정보 조회
	@Transactional
	public SongEntity getSongById(int songIdx) {
		return songRepository.findById(songIdx).orElseThrow(() -> new NotFoundException(
			ErrorCode.SONG_NOT_FOUND));
	}
}