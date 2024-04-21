package com.example.demo.repository;

import com.example.demo.model.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<GameAuthor, Long> {
    Optional<GameAuthor> findByNickname(String nickname);
    List<GameAuthor> findAllByBirthDate(Date birthDate);
}
