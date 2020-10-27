package com.example.chat.kafka.consumer.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.api.model.Role;
import com.example.chat.api.model.Room;
import com.example.chat.api.model.User;
import com.example.chat.kafka.consumer.entity.Message;
import com.example.chat.kafka.consumer.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

/**
 * TODO: MessageController
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

	private final MessageRepository messageRepository;

	@PostMapping
	public Message saveMessage(@RequestParam String messageString) {
		Message message = new Message();
		message.setMessageId(UUID.randomUUID());
		message.setMessage(messageString);
		Room room = new Room();
		room.setRoomId(1L);
		room.setRoomName("Diplomatervezés II.");
		message.setRoom(room);
		User user = new User();
		user.setEmail("vecsi1994@hotmail.com");
		user.setName("Vécsi Ádám");
		user.setNeptun("IZBTF9");
		user.setRole(Role.STUDENT);
		message.setSenderUser(user);
		message.setDateTime(LocalDateTime.now());
		return messageRepository.save(message);
	}
}