package com.example.Overseas_Purchasing.repository;

import com.example.Overseas_Purchasing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 根據 account 查詢使用者
    Optional<User> findByAccount(String account);

    // 檢查是否存在指定 account 的使用者
    boolean existsByAccount(String account);
}
