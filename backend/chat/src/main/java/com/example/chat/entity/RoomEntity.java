package com.example.chat.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity object to store rooms in relation database.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */

@Data
@Entity
@Table(name = "room")
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Long roomId;

	@Column(name = "room_name")
	private String roomName;

	@Column(name = "subject_id")
	private String subjectId;

	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "room")
	private List<DatabaseMessageEntity> messages;

}
