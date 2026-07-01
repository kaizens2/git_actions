package com.ronak.springboot4.api;

import com.ronak.springboot4.domain.User;
import com.ronak.springboot4.dto.UserDTO;
import com.ronak.springboot4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestAPI {

	private final UserRepository userRepository;

	String greeting = "Hello World!";

	@GetMapping("/greet")
	public String greet() {
		User u = User.builder().name("Ronak").password("123456").email("ronak@gmail.com").build();
		userRepository.save(u);
		return greeting;
	}

	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		List<UserDTO> data = userRepository.findAllUser();
		IO.println("Data : " + data.size());
		return data;
	}

}
