package com.kuze.bigdata.study.springboot.service;

import com.kuze.bigdata.study.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User,Long> {

}
