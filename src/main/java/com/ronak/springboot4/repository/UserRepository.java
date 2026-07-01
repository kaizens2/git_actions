package com.ronak.springboot4.repository;

import com.ronak.springboot4.domain.User;
import com.ronak.springboot4.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("""
			select new com.ronak.springboot4.dto.UserDTO(u.id,u.name,u.email,u.password) from User u
			""")
	List<UserDTO> findAllUser();

}
