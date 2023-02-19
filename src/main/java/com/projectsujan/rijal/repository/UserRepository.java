package com.projectsujan.rijal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectsujan.rijal.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

	User save(User user);

}
