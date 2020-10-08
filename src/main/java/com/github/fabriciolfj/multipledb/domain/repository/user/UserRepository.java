package com.github.fabriciolfj.multipledb.domain.repository.user;

import com.github.fabriciolfj.multipledb.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
