package com.fastdemo.demo.Repository;

import com.fastdemo.demo.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
