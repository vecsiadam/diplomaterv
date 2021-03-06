package com.example.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for users.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long userId;

	private String neptun;

	private String name;

	private String email;

	private Role role;

}
