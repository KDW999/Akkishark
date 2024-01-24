package org.example.back.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class VideoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int video_idx;

	@CreationTimestamp
	private Timestamp video_date;

	private String video_title;

	@Lob
	private String video_picture;

	private int user_idx;
}
