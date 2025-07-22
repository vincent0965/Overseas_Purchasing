package com.example.Overseas_Purchasing.repository;

import com.example.Overseas_Purchasing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 根據 username 查詢使用者
    Optional<User> findByUsername(String username);

    // 檢查是否存在指定 username 的使用者
    boolean existsByUsername(String username);
}
