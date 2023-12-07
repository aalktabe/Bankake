package com.project.bank.dao.repository;

import com.project.bank.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM accounts a WHERE a.user_id = :userId", nativeQuery = true)
    List<Account> findAllAccountsByUserId(@Param("userId") Long userId);
}
